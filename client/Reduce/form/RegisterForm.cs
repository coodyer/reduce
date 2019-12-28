using Reduce.impl;
using Reduce.impl.vo.msg;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Reduce
{
    public partial class RegisterForm : Form
    {
        public RegisterForm()
        {
            InitializeComponent();
        }

        private void LinkLabel1_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            VerificatImpl verificatImpl = new VerificatImpl();
            MsgEntity<String> msg = verificatImpl.sendCode(EmailTextBox.Text);
            MessageBox.Show(msg.Msg);
        }

        private void Button1_Click(object sender, EventArgs e)
        {
            UserImpl userImpl = new UserImpl();
            MsgEntity<String> msg = userImpl.create(EmailTextBox.Text.Trim(), PasswordTextBox.Text.Trim(), CodeTextBox.Text.Trim());
            if (msg.Code != 200)
            {
                MessageBox.Show(msg.Msg);
                return;
            }
            MainForm main = new MainForm();
            this.Hide();
            main.Show();
        }
    }
}
