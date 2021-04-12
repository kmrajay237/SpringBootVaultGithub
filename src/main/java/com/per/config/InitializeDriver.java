package com.per.config;

import java.util.HashMap;
import java.util.Map;

import com.bettercloud.vault.Vault;
import com.bettercloud.vault.VaultConfig;
import com.bettercloud.vault.VaultException;
import com.bettercloud.vault.response.LogicalResponse;

public class InitializeDriver {
	
	public static void main(String[] args) throws VaultException {
		final VaultConfig config =
			    new VaultConfig()
			        .address("http://127.0.0.1:8200")               // Defaults to "VAULT_ADDR" environment variable
			        .token("3c9fd6be-7bc2-9d1f-6fb3-cd746c0fc4e8")  // Defaults to "VAULT_TOKEN" environment variable
			        .openTimeout(5)                                 // Defaults to "VAULT_OPEN_TIMEOUT" environment variable
			        .readTimeout(30)                                // Defaults to "VAULT_READ_TIMEOUT" environment variable
//			        .sslConfig(new SslConfig().build())             // See "SSL Config" section below
			        .build();
		
		final Vault vault = new Vault(config);
		
		final Map<String, Object> secrets = new HashMap<String, Object>();
		secrets.put("value", "world");
		secrets.put("other_value", "You can store multiple name/value pairs under a single key");

		// Write operation
		final LogicalResponse writeResponse = vault.logical()
		                                        .write("secret/hello", secrets);
		
		
		final String value = vault.logical()
                .read("secret/hello")
                .getData().get("value");
	}

}
