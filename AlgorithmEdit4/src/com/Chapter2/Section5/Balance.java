package com.Chapter2.Section5;

import java.math.BigDecimal;

public class Balance implements Comparable<Balance>{

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Balance other = (Balance) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		return true;
	}

	public void setAccount(BigDecimal account) {
		this.account = account;
	}

	private BigDecimal account;
	@Override
	public int compareTo(Balance o) {
		return account.compareTo(o.account);
	}
	
	public static void main(String[] args) {
		Balance balance1 = new Balance();
		balance1.setAccount(new BigDecimal(12));
		
		Balance balance2 = new Balance();
		balance2.setAccount(new BigDecimal(12));
		
		System.out.println(balance1.compareTo(balance2));
	}
	
	

}
