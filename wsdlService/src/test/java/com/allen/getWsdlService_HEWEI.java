package com.allen;

import java.rmi.RemoteException;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

/**
 *
 * 作者:allen
 * 时间:2018年6月7日
 * 作用:和为提供发送webservice方式不可用
 */
public class getWsdlService_HEWEI {

    public String invokeRemoteFuc(String operationType,String protocolType,String protocolName,
                                  String protocolId) {
        String endpoint = "http://localhost:8080/webservice/protocolservice/ProtocolManagerService";
        String result = "no result!";
        Service service = new Service();
        Call call;
        Object object [] = {operationType,protocolType,protocolName,protocolId};
        try {
            call = (Call) service.createCall();
            call.setTargetEndpointAddress(endpoint);// 远程调用路径
            call.setOperationName("notifying");// 调用的方法名

            // 设置参数名:
            call.addParameter("operationType", // 参数名
                    XMLType.XSD_STRING,// 参数类型:String
                    ParameterMode.IN);// 参数模式：'IN' or 'OUT'
            call.addParameter("protocolType", // 参数名
                    XMLType.XSD_STRING,// 参数类型:String
                    ParameterMode.IN);// 参数模式：'IN' or 'OUT'
            call.addParameter("protocolName", // 参数名
                    XMLType.XSD_STRING,// 参数类型:String
                    ParameterMode.IN);// 参数模式：'IN' or 'OUT'
            call.addParameter("protocolId", // 参数名
                    XMLType.XSD_STRING,// 参数类型:String
                    ParameterMode.IN);// 参数模式：'IN' or 'OUT'
            result = (String) call.invoke(object);// 远程调用
        } catch (ServiceException e) {
            //e.printStackTrace();
            System.out.println("wsdl服务Error-ServiceException");
        } catch (RemoteException e) {
            //e.printStackTrace();
            System.out.println("wsdl服务Error-RemoteException");
        }
        return result;
    }

    public static void main(String[] args) {
        String operationType = "aa";
        String protocolType = "aa";
        String protocolName = "aa";
        String protocolId = "aa";

        getWsdlService_HEWEI t = new getWsdlService_HEWEI();
        String result = t.invokeRemoteFuc(operationType,protocolType,protocolName,protocolId);
        System.out.println(result);
    }

}
