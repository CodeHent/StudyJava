package test;

/**
 * 
 * @author QuinnNorris
 * 
 *         继承了Exception的自定义异常类
 */
class DynamicFieldException extends Exception {
}

/**
 * 
 * @author QuinnNorris
 * 
 *         包含一个对象数组以及一些操作的主类
 */
public class DynamicFields {

    private Object[][] fields;

    /**
     * 用传入的大小参数设定初始化数组的行数
     * 
     * @param initialSize
     */
    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++)
            fields[i] = new Object[] { null, null };
    }

    /**
     * 重写toString，以为了能够输出数组
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object[] field : fields) {
            result.append(field[0]);
            result.append(": ");
            result.append(field[1]);
            result.append("\n");
        }
        return result.toString();
    }

    /**
     * 查询是否有是id的field[n][0]
     * 
     * @param id
     * @return
     */
    private int hasField(String id) {
        for (int i = 0; i < fields.length; i++)
            if (id.equals(fields[i][0]))
                return i;
        return -1;
    }

    /**
     * 查询id的索引，如果有就返回索引，如果没有就抛出异常
     * 
     * @param id
     * @return
     * @throws NoSuchFieldException
     */
    private int getFieldNumber(String id) throws NoSuchFieldException {
        int idIndex = hasField(id);
        if (idIndex == -1)
            throw new NoSuchFieldException();
        return idIndex;
    }

    /**
     * 查看全部的fields，将一个新的id添加进去。如果没有空位置就将数组添加一行返回索引。
     * 
     * @param id
     * @return
     */
    private int makeField(String id) {
        for (int i = 0; i < fields.length; i++)
            if (fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
        Object[][] tmp = new Object[fields.length + 1][2];
        for (int i = 0; i < fields.length; i++)
            tmp[i] = fields[i];
        for (int i = fields.length; i < tmp.length; i++)
            tmp[i] = new Object[] { null, null };
        fields = tmp;
        return makeField(id);
    }

    /**
     * 获取id的那一行储存的值
     * 
     * @param id
     * @return
     * @throws NoSuchFieldException
     */
    public Object getField(String id) throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }

    /**
     * 从id中取出值
     * 
     * @param id
     * @param value
     * @return
     * @throws DynamicFieldException
     */
    public Object setField(String id, Object value)
            throws DynamicFieldException {
        if (value == null) {
            DynamicFieldException dfe = new DynamicFieldException();
            dfe.initCause(new NullPointerException());
            throw dfe;
        }
        int fieldNumber = hasField(id);
        if (fieldNumber == -1)
            fieldNumber = makeField(id);
        Object result = null;
        try {
            result = getField(id);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        fields[fieldNumber][1] = value;
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        DynamicFields df = new DynamicFields(3);
        System.out.println(df);

        try {
            df.setField("d", "A value for d");
            df.setField("number", 47);
            df.setField("number2", 48);
            System.out.println(df);
            df.setField("d", "A new value for d");
            df.setField("number3", 11);
            System.out.println("df: " + df);
            Object field = df.setField("d", null);
        } catch (DynamicFieldException e) {
            e.printStackTrace();
        }

    }

}