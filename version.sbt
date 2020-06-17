val branchName = sys.env.get("BRANCH").map(e => s"-$e").getOrElse("")
version in ThisBuild := "3.3.1.1" + branchName + "-SNAPSHOT"
