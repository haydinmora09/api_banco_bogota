package co.edu.usbbog.bdd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Cuenta {
	
	@Id
	private long num;
	@Column
	private Double saldo;

	
	public Cuenta(long num, Double saldo) {
		super();
		this.num = num;
		this.saldo = saldo;
	}
	
	public Cuenta() {
		super();
		this.num = 0;
		this.saldo = 0.0;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}


	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (num ^ (num >>> 32));
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
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
		Cuenta other = (Cuenta) obj;
		if (num != other.num)
			return false;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cuenta [num=" + num + ", saldo=" + saldo + "]";
	}


	

}