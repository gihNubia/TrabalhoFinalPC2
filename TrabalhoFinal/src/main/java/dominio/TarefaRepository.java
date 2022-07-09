package dominio;

import java.security.InvalidParameterException;

public class TarefaRepository extends Repository{

    public TarefaRepository(String fileName) {
        super(fileName);
    }

    @Override
    protected Salvable getObject(String line) throws InvalidParameterException {
        String[] data = line.split("§");
        if (data.length != 4)
            throw new InvalidParameterException();
        Tarefa tarefa = new Tarefa(data[0], data[1], data[2], data[3]);
        return tarefa;
    }

}