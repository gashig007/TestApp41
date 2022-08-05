package com.geektech.testapp41.presentation.characterDetail

fun String.extractId() = this.substringAfter("character").replace("/","").toInt()