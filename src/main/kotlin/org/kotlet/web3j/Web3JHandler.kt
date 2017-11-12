package org.kotlet.web3j

import org.slf4j.LoggerFactory
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.DefaultBlockParameter
import org.web3j.protocol.http.HttpService
import java.math.BigInteger

/**
 * Class to interact with the Ethereum blockchain,
 * using Web3J client
 *
 * @author achhabra
 */

class Web3JHandler (private val url: String, private val address: String) {

    private val LOG = LoggerFactory.getLogger("Web3JHandler")
    private val web3j: Web3j

    init {
        if(LOG.isDebugEnabled)
            LOG.debug("Using $url ethereum blockchain")
        LOG.info("Querying details for address $address")
        web3j = Web3j.build(HttpService(url))
    }

    fun getBalance (): BigInteger? {
        val ethBalance = web3j.ethGetBalance(address, DefaultBlockParameter.valueOf("latest")).send()
        return ethBalance.balance
    }

    fun getEthereumClientVersion(): String {
        val clientVersion = web3j.web3ClientVersion().send()
        return clientVersion.web3ClientVersion
    }

    fun getWalletAddress(): String = address

    fun getBlockchainURL(): String = url
}