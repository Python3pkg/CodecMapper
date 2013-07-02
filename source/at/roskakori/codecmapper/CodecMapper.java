/**
 * Write mapping files derived from Java Charsets which can be processed by
 * Python's gencodec.py.
 *
 * @author Thomas Aglassinger
 */
package at.roskakori.codecmapper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class CodecMapper {
    private static final String NEWLINE = System.getProperty("line.separator");

    private static void writeMapping(String encodingName) throws IOException {
        assert encodingName != null;
        Charset charset = Charset.forName(encodingName);
        String mappingPath = encodingName + ".txt";
        byte[] bytes = new byte[1];

        System.out.println("write \"" + mappingPath + "\"");
        FileWriter mappingWriter = new FileWriter(mappingPath);

        mappingWriter.write("# Mapping for " + charset.displayName() + NEWLINE);
        mappingWriter.write("# Aliases: "
                + Arrays.toString(charset.aliases().toArray()) + NEWLINE);
        mappingWriter.write("#" + NEWLINE);
        mappingWriter
                .write("# Generated by CodecMapper, for more information, see"
                        + NEWLINE);
        mappingWriter.write("# https://github.com/roskakori/CodecMapper."
                + NEWLINE);
        try {

            for (int index = 0; index < 256; index++) {
                bytes[0] = (byte) index;
                try {
                    String encoded = new String(bytes, encodingName);
                    char ch = encoded.charAt(0);
                    int code = (int) ch;
                    String name = null;
                    try {
                        name = Character.getName(code);
                    } catch (IllegalArgumentException error) {
                        // Use default.
                    }
                    if (name == null) {
                        name = "";
                    }
                    String line = String.format("0x%02x\t0x%04x\t#%s", index,
                            code, name);
                    mappingWriter.write(line);
                    mappingWriter.write(NEWLINE);
                } catch (UnsupportedEncodingException error) {
                    // Skip unmappable character.
                }
            }
        } finally {
            mappingWriter.close();
        }
    }

    private static void showCharsets() {
        for (String name : Charset.availableCharsets().keySet()) {
            System.out.println(name);
        }
    }

    private static void showHelp() {
        System.err
                .println("Usage: CodecMapper ENCODING\n  Build mapping for ENCODING to be processed by gencodecs.py");
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            showHelp();
        } else {
            String firstArg = args[0];
            if (firstArg.equals("--help") || firstArg.equals("-help")
                    || firstArg.equals("-h")) {
                showHelp();
            } else if (firstArg.equals("--list") || firstArg.equals("-list")
                    || firstArg.equals("-l")) {
                showCharsets();
            } else {
                for (int argIndex = 0; argIndex < args.length; argIndex += 1) {
                    String encodingName = args[argIndex];
                    writeMapping(encodingName);
                }
            }
        }
    }
}