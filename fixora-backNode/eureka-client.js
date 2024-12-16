import { Eureka } from 'eureka-js-client';

const eurekaClient = new Eureka({
  instance: {
    app: 'auth-service', 
    instanceId: 'auth-service:3000', 
    hostName: 'localhost',
    ipAddr: '127.0.0.1',
    port: {
      $: 3000, 
      '@enabled': true,
    },
    vipAddress: 'auth-service',
    dataCenterInfo: {
      '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
      name: 'MyOwn',
    },
  },
  eureka: {
    host: 'localhost',
    port: 8761, 
    servicePath: '/eureka/apps/',
  },
});

eurekaClient.start((error) => {
  if (error) {
    console.error('Eureka client failed to start:', error);
  } else {
    console.log('Eureka client registered successfully');
  }
});

export default eurekaClient;