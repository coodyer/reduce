using Reduce.handle;
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
    public partial class LoginForm : Form
    {
        public LoginForm()
        {
            InitializeComponent();
        }

        private void Login_Load(object sender, EventArgs e)
        {

        }

        private void Button1_Click(object sender, EventArgs e)
        {
            UserImpl userImpl = new UserImpl();
            MsgEntity<String> msg = userImpl.login(EmailTextBox.Text, PasswordTextBox.Text);
            if (msg.Code != 200)
            {
                MessageBox.Show(msg.Msg);
                return;
            }
            MainForm main = new MainForm();
            this.Hide();
            main.Show();
        }

        private void Button2_Click(object sender, EventArgs e)
        {
            RegisterForm register = new RegisterForm();
            this.Hide();
            register.Show();
        }
    }
}
