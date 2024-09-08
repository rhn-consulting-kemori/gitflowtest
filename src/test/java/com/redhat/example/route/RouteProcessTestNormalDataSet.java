package com.redhat.example.route;

// Util
import lombok.Data;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

// Business Object
import com.redhat.example.entity.NyukinRequestEntity;
import com.redhat.example.entity.KijitsuNyukinResponseEntity;
import com.redhat.example.type.DepositResultMessageRequestType;
import com.redhat.example.type.KijitsuAllocationDepositRequestType;
import com.redhat.example.type.KijitsuAllocationDepositResponseType;
import com.redhat.example.type.FormatCheckResponseType;
import com.redhat.example.type.DepositEntryCheckRequestType;
import com.redhat.example.type.DepositEntryCheckResponseType;

@Data
@Component
public class RouteProcessTestNormalDataSet {

    /** Expected Object Data */
    NyukinRequestEntity route_request;
    KijitsuNyukinResponseEntity route_response;
    DepositResultMessageRequestType deposit_result_message_request;
    KijitsuNyukinResponseEntity deposit_result_message_response;
    KijitsuAllocationDepositRequestType kijitsu_allocation_deposit_request;
    KijitsuAllocationDepositResponseType kijitsu_allocation_deposit_response;
    NyukinRequestEntity format_check_request;
    FormatCheckResponseType format_check_response;
    DepositEntryCheckRequestType deposit_entry_check_request;
    DepositEntryCheckResponseType deposit_entry_check_response;

    ObjectMapper mapper = new ObjectMapper();

    public RouteProcessTestNormalDataSet() {
        setRoute_request();
        setRoute_response();
        setDeposit_result_message_request();
        setDeposit_result_message_response();
        setKijitsu_allocation_deposit_request();
        setKijitsu_allocation_deposit_response();
        setFormat_check_request();
        setFormat_check_response();
        setDeposit_entry_check_request();
        setDeposit_entry_check_response();
    }

    /** NyukinRequestEntity route_request */
    public void setRoute_request() {
        route_request = new NyukinRequestEntity();
    }

    /** KijitsuNyukinResponseEntity route_response */
    public void setRoute_response() {
        route_response = new KijitsuNyukinResponseEntity();
    }

    /** DepositResultMessageRequestType deposit_result_message_request */
    public void setDeposit_result_message_request() {
        deposit_result_message_request = new DepositResultMessageRequestType();
    }

    /** KijitsuNyukinResponseEntity deposit_result_message_response */
    public void setDeposit_result_message_response() {
        deposit_result_message_response = new KijitsuNyukinResponseEntity();
    }

    /** KijitsuAllocationDepositRequestType kijitsu_allocation_deposit_request */
    public void setKijitsu_allocation_deposit_request() {
        kijitsu_allocation_deposit_request = new KijitsuAllocationDepositRequestType();
    }

    /** KijitsuAllocationDepositResponseType kijitsu_allocation_deposit_response */
    public void setKijitsu_allocation_deposit_response() {
        kijitsu_allocation_deposit_response = new KijitsuAllocationDepositResponseType();
    }

    /** NyukinRequestEntity format_check_request */
    public void setFormat_check_request() {
        format_check_request = new NyukinRequestEntity();
    }

    /** FormatCheckResponseType format_check_response */
    public void setFormat_check_response() {
        format_check_response = new FormatCheckResponseType();
    }

    /** DepositEntryCheckRequestType deposit_entry_check_request */
    public void setDeposit_entry_check_request() {
        deposit_entry_check_request = new DepositEntryCheckRequestType();
    }

    /** DepositEntryCheckResponseType deposit_entry_check_response */
    public void setDeposit_entry_check_response() {
        deposit_entry_check_response = new DepositEntryCheckResponseType();
    }

}
