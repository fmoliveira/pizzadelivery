namespace DeliveryManager
{
    partial class frmDetalhePedido
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.lblDataHora = new System.Windows.Forms.Label();
            this.lblEspera = new System.Windows.Forms.Label();
            this.lblCliente = new System.Windows.Forms.Label();
            this.lblEndereco = new System.Windows.Forms.Label();
            this.lblBairro = new System.Windows.Forms.Label();
            this.lstItensPedido = new System.Windows.Forms.ListView();
            this.lblValorTotal = new System.Windows.Forms.Label();
            this.lblFormaPagto = new System.Windows.Forms.Label();
            this.txtDataHora = new System.Windows.Forms.Label();
            this.txtEspera = new System.Windows.Forms.Label();
            this.txtCliente = new System.Windows.Forms.Label();
            this.txtEndereco = new System.Windows.Forms.Label();
            this.txtBairro = new System.Windows.Forms.Label();
            this.txtValorTotal = new System.Windows.Forms.Label();
            this.txtFormaPagto = new System.Windows.Forms.Label();
            this.lblTrocoPara = new System.Windows.Forms.Label();
            this.txtTrocoPara = new System.Windows.Forms.Label();
            this.lblValorTroco = new System.Windows.Forms.Label();
            this.txtValorTroco = new System.Windows.Forms.Label();
            this.lblTelefone = new System.Windows.Forms.Label();
            this.txtTelefone = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // lblDataHora
            // 
            this.lblDataHora.AutoSize = true;
            this.lblDataHora.Location = new System.Drawing.Point(12, 9);
            this.lblDataHora.Name = "lblDataHora";
            this.lblDataHora.Size = new System.Drawing.Size(59, 13);
            this.lblDataHora.TabIndex = 0;
            this.lblDataHora.Text = "Data/hora:";
            // 
            // lblEspera
            // 
            this.lblEspera.AutoSize = true;
            this.lblEspera.Location = new System.Drawing.Point(12, 22);
            this.lblEspera.Name = "lblEspera";
            this.lblEspera.Size = new System.Drawing.Size(93, 13);
            this.lblEspera.TabIndex = 2;
            this.lblEspera.Text = "Tempo de espera:";
            // 
            // lblCliente
            // 
            this.lblCliente.AutoSize = true;
            this.lblCliente.Location = new System.Drawing.Point(12, 35);
            this.lblCliente.Name = "lblCliente";
            this.lblCliente.Size = new System.Drawing.Size(88, 13);
            this.lblCliente.TabIndex = 4;
            this.lblCliente.Text = "Nome do Cliente:";
            // 
            // lblEndereco
            // 
            this.lblEndereco.AutoSize = true;
            this.lblEndereco.Location = new System.Drawing.Point(12, 61);
            this.lblEndereco.Name = "lblEndereco";
            this.lblEndereco.Size = new System.Drawing.Size(56, 13);
            this.lblEndereco.TabIndex = 8;
            this.lblEndereco.Text = "Endereço:";
            // 
            // lblBairro
            // 
            this.lblBairro.AutoSize = true;
            this.lblBairro.Location = new System.Drawing.Point(12, 74);
            this.lblBairro.Name = "lblBairro";
            this.lblBairro.Size = new System.Drawing.Size(37, 13);
            this.lblBairro.TabIndex = 10;
            this.lblBairro.Text = "Bairro:";
            // 
            // lstItensPedido
            // 
            this.lstItensPedido.FullRowSelect = true;
            this.lstItensPedido.Location = new System.Drawing.Point(12, 90);
            this.lstItensPedido.MultiSelect = false;
            this.lstItensPedido.Name = "lstItensPedido";
            this.lstItensPedido.Size = new System.Drawing.Size(360, 227);
            this.lstItensPedido.TabIndex = 12;
            this.lstItensPedido.UseCompatibleStateImageBehavior = false;
            // 
            // lblValorTotal
            // 
            this.lblValorTotal.AutoSize = true;
            this.lblValorTotal.Location = new System.Drawing.Point(12, 320);
            this.lblValorTotal.Name = "lblValorTotal";
            this.lblValorTotal.Size = new System.Drawing.Size(61, 13);
            this.lblValorTotal.TabIndex = 13;
            this.lblValorTotal.Text = "Valor Total:";
            // 
            // lblFormaPagto
            // 
            this.lblFormaPagto.AutoSize = true;
            this.lblFormaPagto.Location = new System.Drawing.Point(12, 333);
            this.lblFormaPagto.Name = "lblFormaPagto";
            this.lblFormaPagto.Size = new System.Drawing.Size(111, 13);
            this.lblFormaPagto.TabIndex = 15;
            this.lblFormaPagto.Text = "Forma de Pagamento:";
            // 
            // txtDataHora
            // 
            this.txtDataHora.AutoSize = true;
            this.txtDataHora.Location = new System.Drawing.Point(185, 9);
            this.txtDataHora.Name = "txtDataHora";
            this.txtDataHora.Size = new System.Drawing.Size(98, 13);
            this.txtDataHora.TabIndex = 1;
            this.txtDataHora.Text = "1/1/1970 00:00:00";
            // 
            // txtEspera
            // 
            this.txtEspera.AutoSize = true;
            this.txtEspera.Location = new System.Drawing.Point(185, 22);
            this.txtEspera.Name = "txtEspera";
            this.txtEspera.Size = new System.Drawing.Size(38, 13);
            this.txtEspera.TabIndex = 3;
            this.txtEspera.Text = "45 min";
            // 
            // txtCliente
            // 
            this.txtCliente.AutoSize = true;
            this.txtCliente.Location = new System.Drawing.Point(185, 35);
            this.txtCliente.Name = "txtCliente";
            this.txtCliente.Size = new System.Drawing.Size(39, 13);
            this.txtCliente.TabIndex = 5;
            this.txtCliente.Text = "Fulano";
            // 
            // txtEndereco
            // 
            this.txtEndereco.AutoSize = true;
            this.txtEndereco.Location = new System.Drawing.Point(185, 61);
            this.txtEndereco.Name = "txtEndereco";
            this.txtEndereco.Size = new System.Drawing.Size(63, 13);
            this.txtEndereco.TabIndex = 9;
            this.txtEndereco.Text = "Rua Tal, 45";
            // 
            // txtBairro
            // 
            this.txtBairro.AutoSize = true;
            this.txtBairro.Location = new System.Drawing.Point(185, 74);
            this.txtBairro.Name = "txtBairro";
            this.txtBairro.Size = new System.Drawing.Size(72, 13);
            this.txtBairro.TabIndex = 11;
            this.txtBairro.Text = "Vila Palmeiras";
            // 
            // txtValorTotal
            // 
            this.txtValorTotal.AutoSize = true;
            this.txtValorTotal.Location = new System.Drawing.Point(185, 320);
            this.txtValorTotal.Name = "txtValorTotal";
            this.txtValorTotal.Size = new System.Drawing.Size(57, 13);
            this.txtValorTotal.TabIndex = 14;
            this.txtValorTotal.Text = "R$ 120,00";
            // 
            // txtFormaPagto
            // 
            this.txtFormaPagto.AutoSize = true;
            this.txtFormaPagto.Location = new System.Drawing.Point(185, 333);
            this.txtFormaPagto.Name = "txtFormaPagto";
            this.txtFormaPagto.Size = new System.Drawing.Size(46, 13);
            this.txtFormaPagto.TabIndex = 16;
            this.txtFormaPagto.Text = "Dinheiro";
            // 
            // lblTrocoPara
            // 
            this.lblTrocoPara.AutoSize = true;
            this.lblTrocoPara.Location = new System.Drawing.Point(12, 346);
            this.lblTrocoPara.Name = "lblTrocoPara";
            this.lblTrocoPara.Size = new System.Drawing.Size(63, 13);
            this.lblTrocoPara.TabIndex = 17;
            this.lblTrocoPara.Text = "Troco Para:";
            // 
            // txtTrocoPara
            // 
            this.txtTrocoPara.AutoSize = true;
            this.txtTrocoPara.Location = new System.Drawing.Point(185, 346);
            this.txtTrocoPara.Name = "txtTrocoPara";
            this.txtTrocoPara.Size = new System.Drawing.Size(57, 13);
            this.txtTrocoPara.TabIndex = 18;
            this.txtTrocoPara.Text = "R$ 200,00";
            // 
            // lblValorTroco
            // 
            this.lblValorTroco.AutoSize = true;
            this.lblValorTroco.Location = new System.Drawing.Point(12, 359);
            this.lblValorTroco.Name = "lblValorTroco";
            this.lblValorTroco.Size = new System.Drawing.Size(80, 13);
            this.lblValorTroco.TabIndex = 19;
            this.lblValorTroco.Text = "Valor do Troco:";
            // 
            // txtValorTroco
            // 
            this.txtValorTroco.AutoSize = true;
            this.txtValorTroco.Location = new System.Drawing.Point(185, 359);
            this.txtValorTroco.Name = "txtValorTroco";
            this.txtValorTroco.Size = new System.Drawing.Size(51, 13);
            this.txtValorTroco.TabIndex = 20;
            this.txtValorTroco.Text = "R$ 80,00";
            // 
            // lblTelefone
            // 
            this.lblTelefone.AutoSize = true;
            this.lblTelefone.Location = new System.Drawing.Point(12, 48);
            this.lblTelefone.Name = "lblTelefone";
            this.lblTelefone.Size = new System.Drawing.Size(52, 13);
            this.lblTelefone.TabIndex = 6;
            this.lblTelefone.Text = "Telefone:";
            // 
            // txtTelefone
            // 
            this.txtTelefone.AutoSize = true;
            this.txtTelefone.Location = new System.Drawing.Point(185, 48);
            this.txtTelefone.Name = "txtTelefone";
            this.txtTelefone.Size = new System.Drawing.Size(58, 13);
            this.txtTelefone.TabIndex = 7;
            this.txtTelefone.Text = "1234-5678";
            // 
            // frmDetalhePedido
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(384, 381);
            this.Controls.Add(this.txtValorTroco);
            this.Controls.Add(this.txtTrocoPara);
            this.Controls.Add(this.txtFormaPagto);
            this.Controls.Add(this.txtValorTotal);
            this.Controls.Add(this.txtBairro);
            this.Controls.Add(this.txtEndereco);
            this.Controls.Add(this.txtTelefone);
            this.Controls.Add(this.txtCliente);
            this.Controls.Add(this.txtEspera);
            this.Controls.Add(this.txtDataHora);
            this.Controls.Add(this.lblValorTroco);
            this.Controls.Add(this.lblTrocoPara);
            this.Controls.Add(this.lblFormaPagto);
            this.Controls.Add(this.lblValorTotal);
            this.Controls.Add(this.lstItensPedido);
            this.Controls.Add(this.lblBairro);
            this.Controls.Add(this.lblEndereco);
            this.Controls.Add(this.lblTelefone);
            this.Controls.Add(this.lblCliente);
            this.Controls.Add(this.lblEspera);
            this.Controls.Add(this.lblDataHora);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "frmDetalhePedido";
            this.ShowIcon = false;
            this.ShowInTaskbar = false;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Detalhes do Pedido";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblDataHora;
        private System.Windows.Forms.Label lblEspera;
        private System.Windows.Forms.Label lblCliente;
        private System.Windows.Forms.Label lblEndereco;
        private System.Windows.Forms.Label lblBairro;
        private System.Windows.Forms.ListView lstItensPedido;
        private System.Windows.Forms.Label lblValorTotal;
        private System.Windows.Forms.Label lblFormaPagto;
        private System.Windows.Forms.Label txtDataHora;
        private System.Windows.Forms.Label txtEspera;
        private System.Windows.Forms.Label txtCliente;
        private System.Windows.Forms.Label txtEndereco;
        private System.Windows.Forms.Label txtBairro;
        private System.Windows.Forms.Label txtValorTotal;
        private System.Windows.Forms.Label txtFormaPagto;
        private System.Windows.Forms.Label lblTrocoPara;
        private System.Windows.Forms.Label txtTrocoPara;
        private System.Windows.Forms.Label lblValorTroco;
        private System.Windows.Forms.Label txtValorTroco;
        private System.Windows.Forms.Label lblTelefone;
        private System.Windows.Forms.Label txtTelefone;
    }
}