package br.com.projedata.teste.util.email;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @since  1.0
 */
public class StringBufferOutPutStream extends OutputStream{
    private StringBuffer textBuffer;
    
    public StringBufferOutPutStream(StringBuffer textBuffer){
        super();
        this.textBuffer = textBuffer;
    }

    /*
     * @see java.io.OutputStream#write(int)
     */
    @Override
    public void write(int b) throws IOException{
        char a = (char)b;
        textBuffer.append(a);
    }

    public String toString(){
        return textBuffer.toString();
    }
}