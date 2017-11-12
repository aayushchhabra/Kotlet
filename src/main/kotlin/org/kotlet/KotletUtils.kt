package org.kotlet

import org.apache.commons.cli.BasicParser
import org.apache.commons.cli.Options
import org.kotlet.web3j.Web3JHandler
import org.slf4j.LoggerFactory

/**
 * Util methods for Kotlet
 *
 * @author achhabra
 */

@Throws(IllegalArgumentException::class)
fun getCLArgs(args: Array<String>): Pair<String, String> {
    // CL options
    val options = Options()
    // Ethereum blockchain URL, by default it points to localhost:8545
    options.addOption("url", true, "URL to connect to an ethereum blockchain")
    // Address of the Ethereum wallet
    options.addOption("wallet_address", true, "Address of the wallet to explore")

    val parser = BasicParser()
    val commandLine = parser.parse(options, args)

    return Pair(commandLine.getOptionValue("url") ?: "http://localhost:8545",
            commandLine.getOptionValue("wallet_address") ?: throw IllegalArgumentException("Unable to parse wallet address"))
}

fun printInfo (handler: Web3JHandler) {
    val LOG = LoggerFactory.getLogger("WALLET")
    LOG.info("Ethereum Client Version - ${handler.getEthereumClientVersion()}")
    LOG.info("Ethereum Blockchain URL - ${handler.getBlockchainURL()}")
    LOG.info("Address - ${handler.getWalletAddress()}")
    LOG.info("Balance - ${handler.getBalance()}")
}