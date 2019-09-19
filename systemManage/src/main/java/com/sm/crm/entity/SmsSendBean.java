package com.sm.crm.entity;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/**
 * 把这个Bean扔到容器  使用的使用直接 注解的方式哪出来的
 * <p>
 * 配置的方式
 */

@PropertySource("classpath:sms.properties")
@Component
public class SmsSendBean {

    @Value("${sms.accesskeyId}")
    private String accesskeyId;

    @Value("${sms.secrect}")
    private String secrect;


    public CommonResponse sendSms(String moibleStr, String code) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accesskeyId, secrect);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", moibleStr);
        request.putQueryParameter("SignName", "王绍成");
        request.putQueryParameter("TemplateCode", "SMS_109030028");
        request.putQueryParameter("TemplateParam", "{\"code\":" + code + "}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            return response;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }

        return null;
    }


    public String getAccesskeyId() {
        return accesskeyId;
    }

    public void setAccesskeyId(String accesskeyId) {
        this.accesskeyId = accesskeyId;
    }

    public String getSecrect() {
        return secrect;
    }

    public void setSecrect(String secrect) {
        this.secrect = secrect;
    }
}
