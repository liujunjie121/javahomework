package club.banyuan.project1.mgt.dto;

import java.util.Map;

/**
 * code : 200
 * message : 操作成功
 * data : {"tokenHead":"Bearer","token":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImNyZWF0ZWQiOjE2MDExNzU1MTQzMzIsImV4cCI6MTYwMTc4MDMxNH0.V7sicTWS8A2SGPlks9E8qkSebH55H7W0AKokXiBLeJ-ZGrfz4WpfgPmHYwpAZaqfe9vNG0TT8qd8KtKsxoBMkg"}
 */
public class Message {

  private int code;
  private String message;
  private Object data;
//  private Map<String,Object> date;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

//  public Map<String, Object> getDate() {
//    return date;
//  }
//
//  public void setDate(Map<String, Object> date) {
//    this.date = date;
//  }


  @Override
  public String toString() {
    return "Message{" +
            "code=" + code +
            ", message='" + message + '\'' +
            ", data=" + data +
            '}';
  }
}