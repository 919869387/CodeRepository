package com.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//加入WebService注解，注意包的名字不要引用错了
@WebService(targetNamespace="/method")
@SOAPBinding(style=Style.RPC)
public class Service {

    /**
     * 该方法共客户端调用，返回字符串
     * @param
     * @return
     * @return String
     */
    @WebMethod(operationName = "notify")
    public void notify(String operationType,String protocolType,String protocolName,
                       String protocolId){
        System.out.println("================wsdlservice收到===============");
        System.out.println(operationType+" "+protocolType+" "+protocolName
                +" "+protocolId);
        System.out.println("=============================================");
    }
}
