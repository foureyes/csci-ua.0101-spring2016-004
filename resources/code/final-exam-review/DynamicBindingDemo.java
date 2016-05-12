
public class DynamicBindingDemo {
    public static void main(String[] args) {
        // hey... notice my declared type is baz
        // but my reference points to a Qux instance
        Baz q = new Qux();
        
        // which version of sayBaz will get executed?
        // JVM will figure this out in runtime! (we know
        // it'll choose sayBaz from Qux rather than Baz)
        q.sayBaz();
        
        // however, compiler is aware if method actually
        // exists in declared type, so this will give us a 
        // compile error, since we declared the type as Baz,
        // which doesn't have sayQux declared (despite the
        // fact that the actual type is Qux)
        // q.sayQux();  
    }
}
class Baz {
    public void sayBaz() {
        System.out.println("Baz!");
    }
}
class Qux extends Baz {
    public void sayQux() {
        System.out.println("Qux");
    }
    public void sayBaz() {
        System.out.println("Baz! (we're inside qux, though).");
    }    
}