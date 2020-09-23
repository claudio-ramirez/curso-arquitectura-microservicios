package com.yavu.apipaciente.clientes;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component("ClientesEureka")
public class ClientesEureka {
	@Autowired
	private DiscoveryClient discoveryClient;

	public URI getUri(String serviceName) {
		List<ServiceInstance> list = discoveryClient.getInstances(serviceName);

		if (list != null && list.size() > 0 ) {
			return list.get(0).getUri();
		}

		return null;
	}
}
