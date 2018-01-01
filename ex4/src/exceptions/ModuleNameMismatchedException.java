package exceptions;

/**
 * ModuleNameMismatchedException
 * @author Aaron-Qiu
 *
 */
public class ModuleNameMismatchedException extends SemanticException
{

    public ModuleNameMismatchedException()
    {
        this("Module Name Mismatched Exception.");
    }

    public ModuleNameMismatchedException(String s)
    {
        super(s);
    }
}