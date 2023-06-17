package br.com.ete.studiogirls;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.ete.studiogirls.model.Servico;

 public class AdapterServicos extends BaseAdapter implements Filterable {


        private LayoutInflater mInflater;
        private ArrayList<Servico> servicos;
        ArrayList<Servico> servicosFiltrados;



        public AdapterServicos(Context context, ArrayList<Servico> servicos) {
            //Itens que preencheram o listview
            this.servicos = servicos;
            servicosFiltrados = servicos;

            //responsavel por pegar o Layout do item.
            mInflater = LayoutInflater.from(context);
        }

        /**
         * Retorna a quantidade de itens
         *
         * @return
         */
        public int getCount() {
            return servicos.size();
        }

        /**
         * Retorna o item de acordo com a posicao dele na tela.
         *
         * @param position
         * @return
         */
        public Servico getItem(int position) {
            return servicos.get(position);
        }

        /**
         * Sem implementação
         *
         * @param position
         * @return
         */
        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View view, ViewGroup parent) {
            //Pega o item de acordo com a posição.
            Servico servico = servicos.get(position);
            //infla o layout para podermos preencher os dados
            view = mInflater.inflate(R.layout.item_lista, null);



            ((TextView) view.findViewById(R.id.textViewDestaque)).setText(servico.getServico().toUpperCase().substring(0,1));
            ((TextView) view.findViewById(R.id.textViewTitulo)).setText(servico.getCliente());
            ((TextView) view.findViewById(R.id.textViewSubtitulo)).setText(servico.getData());



            return view;
        }


        public static String formato(double x) {
            return String.format("%.2f", x);
        }

        public static String formatokG(double x) {
            return String.format("%.3f", x);
        }


        @Override
        public Filter getFilter() {
            return filter;
        }

        Filter filter = new Filter(){

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();

                if (constraint != null && constraint.length() > 0) {
                    ArrayList<Servico> filterList = new ArrayList<Servico>();
                    for (int i = 0; i < servicosFiltrados.size(); i++) {
                        if ((servicosFiltrados.get(i).getCliente().toUpperCase())
                                .contains(constraint.toString().toUpperCase())) {

                            Servico cliente = new Servico();
                            filterList.add(cliente);
                        }
                    }
                    results.count = filterList.size();
                    results.values = filterList;
                } else {
                    results.count = servicosFiltrados.size();
                    results.values = servicosFiltrados;
                }
                return results;

            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults results) {
                servicos = (ArrayList<Servico>) results.values;
                notifyDataSetChanged();
            }
        };
    }







