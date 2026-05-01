
public class ST_Table {

    int STSize = 0;
    int index;
    public ST_Rec[] ST = new ST_Rec[10];

    public void insert_ST(String IDName, String IDType) {
        ST[STSize] = new ST_Rec(IDName, IDType);
        STSize++;

    }

    String getN(int index) {
        return ST[index].IDName;
    }

    String getT(int index) {
        return ST[index].IDType;
    }

    boolean member(String ID) {

        for (int i = 0; i < STSize; i++) {
            if (ID.equals(ST[i].IDName)) {
                return true;
            }
        }
        return false;
    }

    void Run_ST(Record lut[]) {

        for (int i = 0; i < lut.length; i++) {

            if (lut[i].lexem.equals("BODY")) {
                break;
            }

            if (lut[i].lexem.equals("int") || lut[i].lexem.equals("Byte")) {

                for (int j = i + 1; j < lut.length; j++) {

                    if (lut[j].lexem.equals(";")) {
                        break;
                    }

                    if (lut[j].type.equals("ID") && !member(lut[j].lexem)) {
                        insert_ST(lut[j].lexem, lut[i].lexem);
                    }
                }
            }
        }
    }

    void printST() {
        System.out.println("\n--------------------------------------");
        System.out.println("===== Symbol Table =====");
        System.out.println("Index\tID Name\tID Type");
        System.out.println("---------------------------");

        for (int i = 0; i < STSize; i++) {

            System.out.println(i + "\t" + ST[i].IDName + "\t" + ST[i].IDType);
        }
    }
}
