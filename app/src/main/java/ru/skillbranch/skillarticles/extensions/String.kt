package ru.skillbranch.skillarticles.extensions

fun String?.indexesOf(substr: String, ignoreCase: Boolean = true): List<Int> {
    if (substr.isEmpty() || this.isNullOrEmpty()) return emptyList()
    val indexList = mutableListOf<Int>()
    var occurrenceIndex = indexOf(substr, ignoreCase = ignoreCase)
    while (occurrenceIndex != -1) {
        indexList.add(occurrenceIndex)
        occurrenceIndex = indexOf(substr, ++occurrenceIndex, ignoreCase)
    }
    return indexList
}