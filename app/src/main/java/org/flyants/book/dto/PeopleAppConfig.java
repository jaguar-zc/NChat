package org.flyants.book.dto;

public class PeopleAppConfig {
    private Integer chatRecordCloudStore; //聊天记录云存储
    private Integer messageNotifyVoice;//消息通知声音
    private Integer messageNotifyShake;//消息通知震动
    private Integer usePhonePlusMe;//通过手机号添加我
    private Integer useChatNoPlusMe;//通过ID添加我
    private Integer useQrCodePlusMe;//通过二维码添加我
    private Integer addMeVerify;//添加我需要验证
    private Integer allowTomeRecommendedGroup;//允许向我推荐内容
    private Integer dynameicVideoPlayNet;//动态视频自动播放网络  移动网络和WI-FI  仅WI-FI 关闭

    public Integer getChatRecordCloudStore() {
        return chatRecordCloudStore;
    }

    public void setChatRecordCloudStore(Integer chatRecordCloudStore) {
        this.chatRecordCloudStore = chatRecordCloudStore;
    }

    public Integer getMessageNotifyVoice() {
        return messageNotifyVoice;
    }

    public void setMessageNotifyVoice(Integer messageNotifyVoice) {
        this.messageNotifyVoice = messageNotifyVoice;
    }

    public Integer getMessageNotifyShake() {
        return messageNotifyShake;
    }

    public void setMessageNotifyShake(Integer messageNotifyShake) {
        this.messageNotifyShake = messageNotifyShake;
    }

    public Integer getUsePhonePlusMe() {
        return usePhonePlusMe;
    }

    public void setUsePhonePlusMe(Integer usePhonePlusMe) {
        this.usePhonePlusMe = usePhonePlusMe;
    }

    public Integer getUseChatNoPlusMe() {
        return useChatNoPlusMe;
    }

    public void setUseChatNoPlusMe(Integer useChatNoPlusMe) {
        this.useChatNoPlusMe = useChatNoPlusMe;
    }

    public Integer getUseQrCodePlusMe() {
        return useQrCodePlusMe;
    }

    public void setUseQrCodePlusMe(Integer useQrCodePlusMe) {
        this.useQrCodePlusMe = useQrCodePlusMe;
    }

    public Integer getAddMeVerify() {
        return addMeVerify;
    }

    public void setAddMeVerify(Integer addMeVerify) {
        this.addMeVerify = addMeVerify;
    }

    public Integer getAllowTomeRecommendedGroup() {
        return allowTomeRecommendedGroup;
    }

    public void setAllowTomeRecommendedGroup(Integer allowTomeRecommendedGroup) {
        this.allowTomeRecommendedGroup = allowTomeRecommendedGroup;
    }

    public Integer getDynameicVideoPlayNet() {
        return dynameicVideoPlayNet;
    }

    public void setDynameicVideoPlayNet(Integer dynameicVideoPlayNet) {
        this.dynameicVideoPlayNet = dynameicVideoPlayNet;
    }
}
