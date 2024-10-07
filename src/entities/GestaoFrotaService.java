package entities;

import java.util.ArrayList;
import java.util.List;

public class GestaoFrotaService {
 private List<Veiculo> veiculos;

 public GestaoFrotaService() {
     veiculos = new ArrayList<>();
 }

 public String cadastrarVeiculo(String placa, int ano, int numeroPortas) {

     if (placa == null || placa.isEmpty()) {
         return "Erro: Placa não pode estar em branco.";
     }
     if (ano <= 0) {
         return "Erro: O ano do veículo deve ser maior que 0.";
     }
     if (numeroPortas <= 0) {
         return "Erro: O número de portas deve ser maior que 0.";
     }
     if (buscarVeiculoPorPlaca(placa) != null) {
         return "Erro: Já existe um veículo com essa placa.";
     }

     Veiculo novoVeiculo = new Veiculo(placa, ano, numeroPortas);
     veiculos.add(novoVeiculo);
     return "Veículo cadastrado com sucesso!";
 }

 public List<Veiculo> listarVeiculos() {
     return veiculos;
 }

 public Veiculo buscarVeiculoPorPlaca(String placa) {
     for (Veiculo v : veiculos) {
         if (v.getPlaca().equalsIgnoreCase(placa)) {
             return v;
         }
     }
     return null;
 }

 public String removerVeiculo(String placa) {
     Veiculo veiculo = buscarVeiculoPorPlaca(placa);
     if (veiculo != null) {
         veiculos.remove(veiculo);
         return "Veículo removido com sucesso!";
     }
     return "Erro: Veículo não encontrado.";
 }
}
