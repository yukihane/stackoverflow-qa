import java.foreign.NativeTypes;
import java.foreign.Scope;
import java.foreign.memory.Pointer;

public class Main {

    public static void main(final String[] args) {
        final Scope scope = greeter_lib.scope();

        final Pointer<Byte> name = scope.allocateCString("錆びたお茶");
        final long size = 256;
        final Pointer<Byte> message = scope.allocateArray(NativeTypes.UINT8, size).elementPointer();

        greeter_lib.greet(name, message, size);

        final String retval = Pointer.toString(message);
        System.out.println(retval);

    }

}
