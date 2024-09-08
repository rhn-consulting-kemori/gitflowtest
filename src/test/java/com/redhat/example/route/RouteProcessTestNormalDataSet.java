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
public class RouteProcessTestNormalDataSet {

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

    // Constractor: Set Test Data
    public RouteProcessTestNormalDataSet() {
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

    /** KijitsuNyukinRequestEntity route_request */
    public void setRoute_request() {
        String route_process_request_json = """
            {
                "REQUEST_ID": "A-001", 
                "CARD_NUMBER": "3540000100010001", 
                "CUSTOMER_CONTRACT_NUMBER": "0000000001", 
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
        format_check_request = route_request;
    }

    /** FormatCheckResponseType format_check_response */
    public void setFormat_check_response() {
        format_check_response = new FormatCheckResponseType();
        format_check_response.setResponse_result("0");
        format_check_response.setErr_code("");
        format_check_response.setErr_context("");
    }

    /** DepositEntryCheckRequestType deposit_entry_check_request */
    public void setDeposit_entry_check_request() {
        deposit_entry_check_request = new DepositEntryCheckRequestType();
        deposit_entry_check_request.setRequest_id(route_request.getRequest_id());
        deposit_entry_check_request.setCard_number(route_request.getCard_number());
        deposit_entry_check_request.setCustomer_contract_number(route_request.getCustomer_contract_number());
        deposit_entry_check_request.setCustomer_billing_due_date(route_request.getCustomer_billing_due_date());
        deposit_entry_check_request.setContract_settlement_date(route_request.getContract_settlement_date());
        deposit_entry_check_request.setDeposit_date(route_request.getDeposit_date());
        deposit_entry_check_request.setDeposit_amount(route_request.getDeposit_amount());
        deposit_entry_check_request.setExcess_money_handling_category(route_request.getExcess_money_handling_category());
    }

    /** DepositEntryCheckResponseType deposit_entry_check_response */
    public void setDeposit_entry_check_response() {
        deposit_entry_check_response = new DepositEntryCheckResponseType();
        deposit_entry_check_response.setService_request(deposit_entry_check_request);
        deposit_entry_check_response.setResponse_result("0");
        deposit_entry_check_response.setErr_code("");
        deposit_entry_check_response.setErr_context("");
    }

    /** KijitsuAllocationDepositRequestType kijitsu_allocation_deposit_request */
    public void setKijitsu_allocation_deposit_request() {
        kijitsu_allocation_deposit_request = new KijitsuAllocationDepositRequestType();
    }

    /** KijitsuAllocationDepositResponseType kijitsu_allocation_deposit_response */
    public void setKijitsu_allocation_deposit_response() {
        kijitsu_allocation_deposit_response = new KijitsuAllocationDepositResponseType();
    }

    /** DepositResultMessageRequestType deposit_result_message_request */
    public void setDeposit_result_message_request() {
        deposit_result_message_request = new DepositResultMessageRequestType();
        deposit_result_message_request.setDeposit_request(route_request);
        deposit_result_message_request.setDeposit_result("0");
        deposit_result_message_request.setErr_code("");
        deposit_result_message_request.setErr_context("");
        deposit_result_message_request.setDeposit_data(deposit_response.getDeposit_data());
    }

    /** KijitsuNyukinResponseEntity deposit_result_message_response */
    public void setDeposit_result_message_response() {
        deposit_result_message_response = new KijitsuNyukinResponseEntity();
        deposit_result_message_response.setDeposit_request(route_request);
        deposit_result_message_response.setDeposit_result("0");
        deposit_result_message_response.setErr_code("");
        deposit_result_message_response.setErr_context("");
        deposit_result_message_response.setDeposit_category_code(deposit_response.getDeposit_data().getDeposit_category_code());
        deposit_result_message_response.setDeposit_allocation_amount(deposit_response.getDeposit_data().getDeposit_allocation_amount());
        deposit_result_message_response.setExcess_money(deposit_response.getDeposit_data().getExcess_money());
        deposit_result_message_response.setEstimated_billing_amount(deposit_response.getDeposit_data().getEstimated_billing_amount());
        deposit_result_message_response.setBalance_amount(deposit_response.getDeposit_data().getBalance_amount());
    }

    /** KijitsuNyukinResponseEntity route_response */
    public void setRoute_response() {
        route_response = deposit_result_message_response;
    }

}
