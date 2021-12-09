package br.com.kingofservice.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class MeusServicos : AppCompatActivity() {

    lateinit var buttonPedidos: Button
    lateinit var buttonEmAndamento: Button
    lateinit var buttonConcluido: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meus_servicos)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.drawable.logo)
        supportActionBar!!.setDisplayUseLogoEnabled(true)
        supportActionBar!!.setBackgroundDrawable(getDrawable(R.drawable.toolbar))

        buttonPedidos = findViewById(R.id.btn_pedidos)
        buttonEmAndamento = findViewById(R.id.btn_em_andamento)
        buttonConcluido = findViewById(R.id.btn_concluido)

        buttonPedidos.setOnClickListener {
            val intent = Intent(this, PedidosPrestador::class.java)
            startActivity(intent)
        }

        buttonEmAndamento.setOnClickListener {
            val intent = Intent(this, EmAndamentoPrestador::class.java)
            startActivity(intent)
        }

        buttonConcluido.setOnClickListener {
            val intent = Intent(this, ConcluidoPrestador::class.java)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_opcoes_cliente,menu);
        return true;
    }

    private fun TelaCategorias() {
        val intent = Intent(this, TelaFeed::class.java)
        startActivity(intent)
    }

    private fun TelaBusca() {
        val intent = Intent(this, TelaListagem::class.java)
        startActivity(intent)
    }

    private fun TelaPerfilPrestador() {
        val intent = Intent( this, TelaPerfilPrestador::class.java)
        startActivity(intent)
    }

    private fun sairLogout() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.profile -> {
                TelaPerfilPrestador()
                return true
            }

            R.id.busca_servicos -> {
                TelaBusca()
                return true
            }

            R.id.principais_categorias -> {
                TelaCategorias()
                return true
            }

            R.id.logout -> {
                sairLogout()
                return true
            }

        }

        return super.onOptionsItemSelected(item)
    }
}