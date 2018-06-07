package com.allen;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import javax.xml.namespace.QName;

public class getWsdlService {

    public static void main(String[] args){
        sendWebService();
    }

    /**
     *
     * 作者:allen
     * 时间:2018年6月1日
     * 作用:发送webservice
     */
    static void sendWebService() {
        //线程外部传参不可以
        String url="http://localhost:8080/webservice/protocolservice/ProtocolManagerService?wsdl"; //wsdl地址
        String tns = "/method";  									   //命名空间
        String method="notifying";

        try {
            RPCServiceClient serviceClient = new RPCServiceClient();
            Options options = serviceClient.getOptions();
            // 指定调用WebService的URL
            EndpointReference targetEPR = new EndpointReference(url);
            options.setTo(targetEPR);

            // 指定要调用的WSDL文件的命名空间及getValue方法
            QName qn = new QName(tns, method);
            // 指定getValue方法的参数值
            Object[] ob = new Object[] { "operationType","protocolType","protocolName","protocolId"};
            // 指定getValue方法返回值的数据类型的Class对象
            Class[] classes = new Class[] { Object.class };
            // 调用getValue方法并输出该方法的返回值
            serviceClient.invokeBlocking(qn,ob);

        } catch (AxisFault e) {
            System.out.println("webservice出错");
        }
    }
}
