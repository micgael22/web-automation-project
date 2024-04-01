package exceptions;

public class TargetNotValidException extends IllegalStateException{

    public TargetNotValidException(String target) {
        super(String.format("======= USE LOCAL OR GRID. TARGET NOT SUPPORTED =======", target));
    }
}
