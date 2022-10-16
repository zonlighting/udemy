package ssv.com.sfgdi.services;

import java.util.Set;

import ssv.com.sfgdi.model.Owner;

public interface OwnerServiceImpl {

	Owner findByLastName(String lastName);

	Owner findById(Long id);

	Owner save(Owner owner);

	Set<Owner> findAll();
}
