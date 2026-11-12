import json
import os
import urllib.request
from collections import defaultdict

SOURCE_DIR = "my-submissions"
README_FILE = "README.md"
USERNAME = "MidziOO"


def fetch_problem_info(slug):
    url = "https://leetcode.com/graphql"
    query = """
    query getQuestionDetail($titleSlug: String!) {
      question(titleSlug: $titleSlug) {
        questionFrontendId
        title
        difficulty
        topicTags {
          name
        }
      }
    }
    """
    payload = json.dumps({"query": query, "variables": {"titleSlug": slug}}).encode("utf-8")
    req = urllib.request.Request(
        url,
        data=payload,
        headers={
            "Content-Type": "application/json",
            "User-Agent": "Mozilla/5.0",
        },
    )
    try:
        with urllib.request.urlopen(req, timeout=10) as resp:
            data = json.loads(resp.read().decode("utf-8"))
            return data.get("data", {}).get("question")
    except Exception:
        return None


def format_difficulty(diff):
    badges = {
        "Easy": "🟢 Easy",
        "Medium": "🟡 Medium",
        "Hard": "🔴 Hard",
    }
    return badges.get(diff, diff)


def main():
    if not os.path.exists(SOURCE_DIR):
        return

    all_problems = []
    by_tag = defaultdict(list)
    diff_counts = {"Easy": 0, "Medium": 0, "Hard": 0}

    for folder in sorted(os.listdir(SOURCE_DIR)):
        src_path = os.path.join(SOURCE_DIR, folder)
        if not os.path.isdir(src_path) or "-" not in folder:
            continue

        num, slug = folder.split("-", 1)
        info = fetch_problem_info(slug)

        difficulty = info["difficulty"] if info else "Unknown"
        title = info["title"] if info else slug.replace("-", " ").title()
        tags = [t["name"] for t in info.get("topicTags", [])] if info else []

        if difficulty in diff_counts:
            diff_counts[difficulty] += 1

        code_files = [f for f in os.listdir(src_path) if f != "README.md"]
        code_link = f"{SOURCE_DIR}/{folder}/{code_files[0]}" if code_files else f"{SOURCE_DIR}/{folder}"

        entry = {
            "id": num,
            "title": title,
            "difficulty": difficulty,
            "diff_badge": format_difficulty(difficulty),
            "tags": tags,
            "link": code_link,
        }

        all_problems.append(entry)
        for tag in tags:
            by_tag[tag].append(entry)

    lines = [
        "# 🧩 LeetCode Solutions\n",
        f"A collection of my accepted [LeetCode](https://leetcode.com/u/{USERNAME}/) solutions stored in [`{SOURCE_DIR}/`](./{SOURCE_DIR}), automatically synced and indexed via **GitHub Actions**.\n",
        "---\n",
        "### 📊 Overview & Stats\n",
        f"**Solved Breakdown:** 🟢 Easy: **{diff_counts['Easy']}** | 🟡 Medium: **{diff_counts['Medium']}** | 🔴 Hard: **{diff_counts['Hard']}** | Total: **{len(all_problems)}**\n",
        f"[![LeetCode Stats](https://leetcode-stats-card.vercel.app/?username={USERNAME}&theme=dark)](https://leetcode.com/u/{USERNAME}/)\n",
        "---\n",
        "### 🏷️ Filter by Category (Topics)\n",
        "Click any category below to expand problems belonging to that topic:\n",
    ]

    if by_tag:
        for tag in sorted(by_tag.keys()):
            items = by_tag[tag]
            lines.append(f"<details>\n<summary><b>{tag}</b> ({len(items)})</summary>\n")
            lines.append("| # | Problem | Difficulty | All Topics | Solution |")
            lines.append("|---|---|---|---|---|")
            for item in items:
                topics_str = ", ".join(f"`{t}`" for t in item["tags"]) if item["tags"] else "-"
                lines.append(
                    f"| {item['id']} | {item['title']} | {item['diff_badge']} | {topics_str} | [Code]({item['link']}) |"
                )
            lines.append("\n</details>\n")
    else:
        lines.append("_No categorized problems yet._\n")

    lines.extend([
        "---\n",
        "### 📋 All Problems\n",
        "| # | Problem | Difficulty | Categories | Solution |",
        "|---|---|---|---|---|",
    ])

    for item in all_problems:
        topics_str = ", ".join(f"`{t}`" for t in item["tags"]) if item["tags"] else "-"
        lines.append(
            f"| {item['id']} | {item['title']} | {item['diff_badge']} | {topics_str} | [Code]({item['link']}) |"
        )

    with open(README_FILE, "w", encoding="utf-8") as f:
        f.write("\n".join(lines) + "\n")


if __name__ == "__main__":
    main()
