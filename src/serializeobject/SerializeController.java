package serializeobject;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeController {

    public static String serialize(Object object){
        String serializedObject = null;
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream so = new ObjectOutputStream(bo);
            so.writeObject(object);
            so.flush();
            serializedObject = new String(Base64.encode(bo.toByteArray()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return serializedObject;
        }
    }

    public static Object deserialize(String object){
        Object deserializedObject = null;
        try {
            byte b[] = Base64.decode(object);
            ByteArrayInputStream bi = new ByteArrayInputStream(b);
            ObjectInputStream si = new ObjectInputStream(bi);
            deserializedObject = si.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            return deserializedObject;
        }
    }
}
