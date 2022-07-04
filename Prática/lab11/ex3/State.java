package ex3;

public interface State {
        public boolean registar(Livros l);
        public boolean devolve(Livros l);
        public boolean cancelaReserva(Livros l);
        public boolean take(Livros l);
        public boolean reserva(Livros l);
    }