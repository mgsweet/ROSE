package exceptions;

/**
 * ProcedureNameMismatchedException
 * @author Aaron-Qiu
 *
 */
public class ProcedureNameMismatchedException extends SemanticException
{

    public ProcedureNameMismatchedException()
    {
        this("Procedure Name Mismatched Exception.");
    }

    public ProcedureNameMismatchedException(String s)
    {
        super(s);
    }
}