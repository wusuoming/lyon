package net.slowvic.modal.bean;

import net.slowvic.modal.domain.Address;

import org.springframework.beans.factory.FactoryBean;

public class AddressFactoryBean implements FactoryBean<Address> {

	@Override
	public Class<Address> getObjectType() {
		return Address.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	@Override
	public Address getObject() throws Exception {
		return new Address();
	}
}
