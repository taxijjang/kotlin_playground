package play

fun main() {

    val path = "https://www.airklass.com"
    val regex = Regex("https://(.+).airklass.com(.*)")


    val path2 = "https://dev.airklass.com/page"
    val path3 = "https://asdf.airklass.coomm/page"
    isMatch(path, regex)
    isMatch(path2, regex)
    isMatch(path3, regex)
}

fun isMatch(path: String, regex: Regex){
    if (path.matches(regex)) println("match")
    else println("not match")
}