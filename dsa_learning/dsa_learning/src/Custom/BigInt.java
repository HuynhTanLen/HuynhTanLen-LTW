package Custom;

import Collection.LinkedList;

public class BigInt {
    LinkedList<Integer> list;
    public BigInt(int n) {
        list = new LinkedList<>();
        while (n > 0) {
            list.addFirst(n % 10);
            n /= 10;
        }
    }
    public BigInt(){
        list = new LinkedList<>();
    }
    public BigInt(String s) {
        list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            list.addLast(Integer.parseInt(String.valueOf(s.charAt(i))));
        }
    }
    public BigInt add(BigInt other) {
        int carry = 0;
        BigInt result = new BigInt();
        list.startEnd();
        other.list.startEnd();
        while (!list.endList() && !other.list.endList()) {
            int sum = list.get() + other.list.get() + carry;
            carry = sum / 10; // Cập nhật chuyển số
            result.list.addFirst(sum % 10);
            list.previous();
            other.list.previous();
        }


        while (!list.endList()) {
            int sum = list.get() + carry;
            carry = sum / 10;
            result.list.addFirst(sum % 10);
            list.previous();
        }

        while (!other.list.endList()) {
            int sum = other.list.get() + carry;
            carry = sum / 10;
            result.list.addFirst(sum % 10);
            other.list.previous();
        }


        if (carry != 0) {
            result.list.addFirst(carry);
        }

        return result;
    }
    public BigInt add(int others) {
        BigInt other =new BigInt(others);
        int carry = 0;
        BigInt result = new BigInt();
        list.startEnd();
        other.list.startEnd();


        while (!list.endList() && !other.list.endList()) {
            int sum = list.get() + other.list.get() + carry;
            carry = sum / 10; // Cập nhật chuyển số
            result.list.addFirst(sum % 10);
            list.previous();
            other.list.previous();
        }


        while (!list.endList()) {
            int sum = list.get() + carry;
            carry = sum / 10;
            result.list.addFirst(sum % 10);
            list.previous();
        }

        while (!other.list.endList()) {
            int sum = other.list.get() + carry;
            carry = sum / 10;
            result.list.addFirst(sum % 10);
            other.list.previous();
        }
        if (carry != 0) {
            result.list.addFirst(carry);
        }

        return result;
    }
    public BigInt multiplyWithOneNumber(int other) {
        int carry = 0;
        BigInt result = new BigInt();
        list.startEnd();

        while (!list.endList()) {
            int product = list.get() * other + carry;
            result.list.addFirst(product % 10);
            carry = product / 10;
            list.previous();
        }
        if (carry != 0) {
            result.list.addFirst(carry);
        }
        return result;
    }
    public BigInt multiply(BigInt other) {

        int count=0;
        BigInt result = new BigInt();
        other.list.startEnd();
        while (!other.list.endList()) {
            BigInt temp;
            int num=other.list.get();
            temp=multiplyWithOneNumber(num);
            for(int i=0;i<count;i++){
                temp.list.addLast(0);
            }
            result=result.add(temp);
            count++;
            other.list.previous();
        }
        return result;
    }
    public BigInt multiply(String others) {
        BigInt other=new BigInt(others);
        int d=0;
        int count=0;
        BigInt result = new BigInt();
        other.list.startEnd();
        while (!other.list.endList()) {
            BigInt temp;
            int num=other.list.get();
            temp=multiplyWithOneNumber(num);
            for(int i=0;i<count;i++){
                temp.list.addLast(0);
            }
            result=result.add(temp);
            count++;
            other.list.previous();

        }
        return result;
    }
    public BigInt multiply(int others) {
        BigInt other=new BigInt(others);
        int count=0;
        BigInt result = new BigInt();
        other.list.startEnd();
        while (!other.list.endList()) {
            BigInt temp;
            int num=other.list.get();
            temp=multiplyWithOneNumber(num);
            for(int i=0;i<count;i++){
                temp.list.addLast(0);
            }
            result=result.add(temp);
            count++;
            other.list.previous();

        }
        return result;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        list.startFirst();
        while (!list.endList()) {
            sb.append(list.get());
            list.next();
        }
        return sb.toString();
    }

}
