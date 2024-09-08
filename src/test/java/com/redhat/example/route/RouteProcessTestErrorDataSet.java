package com.redhat.example.route;

// Util
import lombok.Data;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

// Business Object
import com.redhat.example.entity.KijitsuNyukinRequestEntity;
import com.redhat.example.type.FormatCheckResponseType;
import com.redhat.example.type.DepositEntryCheckRequestType;
import com.redhat.example.type.DepositEntryCheckResponseType;
import com.redhat.example.type.KijitsuAllocationDepositRequestType;
import com.redhat.example.type.KijitsuAllocationDepositResponseType;
import com.redhat.example.type.DepositResultMessageRequestType;
import com.redhat.example.entity.KijitsuNyukinResponseEntity;
import com.redhat.example.entity.DepositDataEntity;

@Data
@Component
public class RouteProcessTestErrorDataSet {

    /** Expected Object Data */
    KijitsuNyukinRequestEntity route_request;
    KijitsuNyukinRequestEntity format_check_request;
    FormatCheckResponseType format_check_response;
    DepositEntryCheckRequestType deposit_entry_check_request;
    DepositEntryCheckResponseType deposit_entry_check_response;
    KijitsuAllocationDepositRequestType kijitsu_allocation_deposit_request;
    KijitsuAllocationDepositResponseType kijitsu_allocation_deposit_response;
    DepositResultMessageRequestType deposit_result_message_request;
    KijitsuNyukinResponseEntity deposit_result_message_response;
    KijitsuNyukinResponseEntity route_response;

    ObjectMapper mapper = new ObjectMapper();

    public RouteProcessTestErrorDataSet() {
        setRoute_request();
        setFormat_check_request();
        setFormat_check_response();
        setDeposit_entry_check_request();
        setDeposit_entry_check_response();
        setKijitsu_allocation_deposit_request();
        setKijitsu_allocation_deposit_response();
        setDeposit_result_message_request();
        setDeposit_result_message_response();
        setRoute_response();
    }

    /** NyukinRequestEntity route_request */
    public void setRoute_request() {
        String route_process_request_json = """
            {
                "REQUEST_ID": "A-002", 
                "CARD_NUMBER": "3540000100010002", 
                "CUSTOMER_CONTRACT_NUMBER": "A000000002", 
                "CUSTOMER_BILLING_DUE_DATE": "20240515", 
                "CONTRACT_SETTLEMENT_DATE":"20240610", 
                "DEPOSIT_DATE": "20240611", 
                "DEPOSIT_AMOUNT": 10000, 
                "EXCESS_MONEY_HANDLING_CATEGORY": "9"
            }
            """;
        try {
            route_request = mapper.readValue(route_process_request_json,KijitsuNyukinRequestEntity.class);
        } catch(JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    /** KijitsuNyukinRequestEntity format_check_request */
    public void setFormat_check_request() {
        format_check_request = new KijitsuNyukinRequestEntity();
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

    /** KijitsuAllocationDepositRequestType kijitsu_allocation_deposit_request */
    public void setKijitsu_allocation_deposit_request() {
        kijitsu_allocation_deposit_request = new KijitsuAllocationDepositRequestType();
    }

    /** KijitsuAllocationDepositResponseType kijitsu_allocation_deposit_response */
    public void setKijitsu_allocation_deposit_response() {
        kijitsu_allocation_deposit_response = new KijitsuAllocationDepositResponseType();
    }

    /** KijitsuNyukinResponseEntity deposit_result_message_response */
    public void setDeposit_result_message_response() {
        deposit_result_message_response = new KijitsuNyukinResponseEntity();
        deposit_result_message_response.setDeposit_request(route_request);
        deposit_result_message_response.setDeposit_result("1");
        deposit_result_message_response.setErr_code("E02");
        deposit_result_message_response.setErr_context("customer_contract_number: numeric error");
    }

    /** KijitsuNyukinResponseEntity route_response */
    public void setRoute_response() {
        route_response = deposit_result_message_response;
    }

}
