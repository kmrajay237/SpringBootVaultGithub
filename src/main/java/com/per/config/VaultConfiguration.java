package com.per.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("example")
public class VaultConfiguration {
	private String bucketName;
    private String awsAccessKeyID;
    private String awsSecretAccessKey;
    private String clientID;
    private String clientSecret;
    private String pdpUser;
    private String pdpPassword;
    
    public String getBucketName() {
		return bucketName;
	}
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}
	
	
	public String getAwsAccessKeyID() {
		return awsAccessKeyID;
	}
	public void setAwsAccessKeyID(String awsAccessKeyID) {
		this.awsAccessKeyID = awsAccessKeyID;
	}
	
	
	public String getAwsSecretAccessKey() {
		return awsSecretAccessKey;
	}
	public void setAwsSecretAccessKey(String awsSecretAccessKey) {
		this.awsSecretAccessKey = awsSecretAccessKey;
	}
	
	
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}
	
	
	public String getClientSecret() {
		return clientSecret;
	}
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	
	
	public String getPdpUser() {
		return pdpUser;
	}
	public void setPdpUser(String pdpUser) {
		this.pdpUser = pdpUser;
	}
	
	
	public String getPdpPassword() {
		return pdpPassword;
	}
	public void setPdpPassword(String pdpPassword) {
		this.pdpPassword = pdpPassword;
	}
}
