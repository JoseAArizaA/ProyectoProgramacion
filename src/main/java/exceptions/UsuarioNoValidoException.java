package exceptions;

import model.Usuario;

public class UsuarioNoValidoException extends Exception{
    public UsuarioNoValidoException(String msn){
        super(msn);
    }
}
