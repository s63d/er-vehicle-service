package com.s63d.ervehicleservice.utils

import java.security.MessageDigest

fun String.md5() : String {
    val data = this.toByteArray()
    val md5 = MessageDigest.getInstance("MD5")
    return md5.digest(data).toHex()
}

private val HEX_CHARS = "0123456789abcdef".toCharArray()

fun ByteArray.toHex() : String{
    val result = StringBuffer()

    forEach {
        val octet = it.toInt()
        val firstIndex = (octet and 0xF0).ushr(4)
        val secondIndex = octet and 0x0F
        result.append(HEX_CHARS[firstIndex])
        result.append(HEX_CHARS[secondIndex])
    }

    return result.toString()
}