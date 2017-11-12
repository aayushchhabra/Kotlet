package main.kotlin

import org.kotlet.getCLArgs
import org.kotlet.printInfo
import org.kotlet.web3j.Web3JHandler


fun main(args: Array<String>) {
    // Get CL Args
    val (url, address) = getCLArgs(args)
    // Web3j handler
    val handler = Web3JHandler(url, address)
    // print wallet and ethereum blockchain info
    printInfo(handler)
}