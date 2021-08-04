package leetcode;

/**
 * 编写一个函数来验证输入的字符串是否是有效的 IPv4 或 IPv6 地址。
 * <p>
 * 如果是有效的 IPv4 地址，返回 "IPv4" ；
 * 如果是有效的 IPv6 地址，返回 "IPv6" ；
 * 如果不是上述类型的 IP 地址，返回 "Neither" 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-ip-address
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code468 {
    public String validIPAddress(String IP) {
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPV4(IP);
        } else if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPV6(IP);
        } else
            return "Neither";
    }

    public String validateIPV4(String IP) {
        String[] address = IP.split("\\.");
        if (address.length != 4) {
            return "Neither";
        }
        for (String s : address) {
            if (s.length() == 0 || s.length() > 3) {
                return "Neither";
            }
            if (s.charAt(0) == '0' && s.length() != 1) {
                return "Neither";
            }
            for (char c : s.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return "Neither";
                }
            }
            if (Integer.parseInt(s) > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    public String validateIPV6(String IP) {
        String[] address = IP.split(":");
        if (address.length != 8) {
            return "Neither";
        }
        String hexdigits = "0123456789abcdefABCDEF";
        for (String s : address) {
            if (s.length() == 0 || s.length() > 4) {
                return "Neither";
            }
            for (Character c : s.toCharArray()) {
                if (hexdigits.indexOf(c) == -1) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }
}
