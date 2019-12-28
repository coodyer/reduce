namespace Reduce
{
    partial class MainForm
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
            this.components = new System.ComponentModel.Container();
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.AppInfoListView = new System.Windows.Forms.ListView();
            this.columnHeader2 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader3 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader4 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader8 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader1 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.AppInfoContextMenuStrip = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.创建应用ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.编辑应用ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.删除应用ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.添加网址ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.刷新列表ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.label1 = new System.Windows.Forms.Label();
            this.PageAddLinkLabel = new System.Windows.Forms.LinkLabel();
            this.PageSubLinkLabel = new System.Windows.Forms.LinkLabel();
            this.ShortListView = new System.Windows.Forms.ListView();
            this.columnHeader5 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader6 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader7 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader9 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader10 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.ShortContextMenuStrip = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.复制本行ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.删除本行ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.刷新列表ToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.tabPage3 = new System.Windows.Forms.TabPage();
            this.tabControl1.SuspendLayout();
            this.tabPage1.SuspendLayout();
            this.AppInfoContextMenuStrip.SuspendLayout();
            this.tabPage2.SuspendLayout();
            this.ShortContextMenuStrip.SuspendLayout();
            this.SuspendLayout();
            // 
            // tabControl1
            // 
            this.tabControl1.Controls.Add(this.tabPage1);
            this.tabControl1.Controls.Add(this.tabPage2);
            this.tabControl1.Controls.Add(this.tabPage3);
            this.tabControl1.Location = new System.Drawing.Point(-2, 1);
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(903, 580);
            this.tabControl1.TabIndex = 0;
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.AppInfoListView);
            this.tabPage1.Location = new System.Drawing.Point(4, 28);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(895, 548);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "应用列表";
            this.tabPage1.UseVisualStyleBackColor = true;
            // 
            // AppInfoListView
            // 
            this.AppInfoListView.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader2,
            this.columnHeader3,
            this.columnHeader4,
            this.columnHeader8,
            this.columnHeader1});
            this.AppInfoListView.ContextMenuStrip = this.AppInfoContextMenuStrip;
            this.AppInfoListView.Dock = System.Windows.Forms.DockStyle.Fill;
            this.AppInfoListView.FullRowSelect = true;
            this.AppInfoListView.GridLines = true;
            this.AppInfoListView.Location = new System.Drawing.Point(3, 3);
            this.AppInfoListView.Margin = new System.Windows.Forms.Padding(4);
            this.AppInfoListView.Name = "AppInfoListView";
            this.AppInfoListView.Size = new System.Drawing.Size(889, 542);
            this.AppInfoListView.TabIndex = 6;
            this.AppInfoListView.UseCompatibleStateImageBehavior = false;
            this.AppInfoListView.View = System.Windows.Forms.View.Details;
            // 
            // columnHeader2
            // 
            this.columnHeader2.Text = "应用ID";
            // 
            // columnHeader3
            // 
            this.columnHeader3.Text = "应用名";
            this.columnHeader3.Width = 120;
            // 
            // columnHeader4
            // 
            this.columnHeader4.Text = "UnionId";
            this.columnHeader4.Width = 160;
            // 
            // columnHeader8
            // 
            this.columnHeader8.Text = "创建时间";
            this.columnHeader8.Width = 140;
            // 
            // columnHeader1
            // 
            this.columnHeader1.Text = "审核状态";
            this.columnHeader1.Width = 80;
            // 
            // AppInfoContextMenuStrip
            // 
            this.AppInfoContextMenuStrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.创建应用ToolStripMenuItem,
            this.编辑应用ToolStripMenuItem,
            this.删除应用ToolStripMenuItem,
            this.添加网址ToolStripMenuItem,
            this.刷新列表ToolStripMenuItem});
            this.AppInfoContextMenuStrip.Name = "AppInfoContextMenuStrip";
            this.AppInfoContextMenuStrip.Size = new System.Drawing.Size(153, 144);
            // 
            // 创建应用ToolStripMenuItem
            // 
            this.创建应用ToolStripMenuItem.Name = "创建应用ToolStripMenuItem";
            this.创建应用ToolStripMenuItem.Size = new System.Drawing.Size(152, 28);
            this.创建应用ToolStripMenuItem.Text = "创建应用";
            this.创建应用ToolStripMenuItem.Click += new System.EventHandler(this.创建应用ToolStripMenuItem_Click);
            // 
            // 编辑应用ToolStripMenuItem
            // 
            this.编辑应用ToolStripMenuItem.Name = "编辑应用ToolStripMenuItem";
            this.编辑应用ToolStripMenuItem.Size = new System.Drawing.Size(152, 28);
            this.编辑应用ToolStripMenuItem.Text = "编辑应用";
            this.编辑应用ToolStripMenuItem.Click += new System.EventHandler(this.编辑应用ToolStripMenuItem_Click);
            // 
            // 删除应用ToolStripMenuItem
            // 
            this.删除应用ToolStripMenuItem.Name = "删除应用ToolStripMenuItem";
            this.删除应用ToolStripMenuItem.Size = new System.Drawing.Size(152, 28);
            this.删除应用ToolStripMenuItem.Text = "删除应用";
            this.删除应用ToolStripMenuItem.Click += new System.EventHandler(this.删除应用ToolStripMenuItem_Click);
            // 
            // 添加网址ToolStripMenuItem
            // 
            this.添加网址ToolStripMenuItem.Name = "添加网址ToolStripMenuItem";
            this.添加网址ToolStripMenuItem.Size = new System.Drawing.Size(152, 28);
            this.添加网址ToolStripMenuItem.Text = "添加网址";
            this.添加网址ToolStripMenuItem.Click += new System.EventHandler(this.添加网址ToolStripMenuItem_Click);
            // 
            // 刷新列表ToolStripMenuItem
            // 
            this.刷新列表ToolStripMenuItem.Name = "刷新列表ToolStripMenuItem";
            this.刷新列表ToolStripMenuItem.Size = new System.Drawing.Size(152, 28);
            this.刷新列表ToolStripMenuItem.Text = "刷新列表";
            this.刷新列表ToolStripMenuItem.Click += new System.EventHandler(this.刷新列表ToolStripMenuItem_Click);
            // 
            // tabPage2
            // 
            this.tabPage2.Controls.Add(this.label1);
            this.tabPage2.Controls.Add(this.PageAddLinkLabel);
            this.tabPage2.Controls.Add(this.PageSubLinkLabel);
            this.tabPage2.Controls.Add(this.ShortListView);
            this.tabPage2.Location = new System.Drawing.Point(4, 28);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(895, 548);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "网址列表";
            this.tabPage2.UseVisualStyleBackColor = true;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(656, 512);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(35, 18);
            this.label1.TabIndex = 10;
            this.label1.Text = "1/1";
            // 
            // PageAddLinkLabel
            // 
            this.PageAddLinkLabel.AutoSize = true;
            this.PageAddLinkLabel.Location = new System.Drawing.Point(764, 510);
            this.PageAddLinkLabel.Name = "PageAddLinkLabel";
            this.PageAddLinkLabel.Size = new System.Drawing.Size(62, 18);
            this.PageAddLinkLabel.TabIndex = 9;
            this.PageAddLinkLabel.TabStop = true;
            this.PageAddLinkLabel.Text = "下一页";
            // 
            // PageSubLinkLabel
            // 
            this.PageSubLinkLabel.AutoSize = true;
            this.PageSubLinkLabel.Location = new System.Drawing.Point(555, 510);
            this.PageSubLinkLabel.Name = "PageSubLinkLabel";
            this.PageSubLinkLabel.Size = new System.Drawing.Size(62, 18);
            this.PageSubLinkLabel.TabIndex = 8;
            this.PageSubLinkLabel.TabStop = true;
            this.PageSubLinkLabel.Text = "上一页";
            // 
            // ShortListView
            // 
            this.ShortListView.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader5,
            this.columnHeader6,
            this.columnHeader7,
            this.columnHeader9,
            this.columnHeader10});
            this.ShortListView.ContextMenuStrip = this.ShortContextMenuStrip;
            this.ShortListView.FullRowSelect = true;
            this.ShortListView.GridLines = true;
            this.ShortListView.Location = new System.Drawing.Point(3, 3);
            this.ShortListView.Margin = new System.Windows.Forms.Padding(4);
            this.ShortListView.Name = "ShortListView";
            this.ShortListView.Size = new System.Drawing.Size(889, 481);
            this.ShortListView.TabIndex = 7;
            this.ShortListView.UseCompatibleStateImageBehavior = false;
            this.ShortListView.View = System.Windows.Forms.View.Details;
            // 
            // columnHeader5
            // 
            this.columnHeader5.Text = "链接ID";
            // 
            // columnHeader6
            // 
            this.columnHeader6.Text = "短链地址";
            this.columnHeader6.Width = 120;
            // 
            // columnHeader7
            // 
            this.columnHeader7.Text = "跳转地址";
            this.columnHeader7.Width = 180;
            // 
            // columnHeader9
            // 
            this.columnHeader9.Text = "访问次数";
            // 
            // columnHeader10
            // 
            this.columnHeader10.Text = "创建时间";
            this.columnHeader10.Width = 140;
            // 
            // ShortContextMenuStrip
            // 
            this.ShortContextMenuStrip.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.复制本行ToolStripMenuItem,
            this.删除本行ToolStripMenuItem,
            this.刷新列表ToolStripMenuItem1});
            this.ShortContextMenuStrip.Name = "ShortContextMenuStrip";
            this.ShortContextMenuStrip.Size = new System.Drawing.Size(153, 110);
            // 
            // 复制本行ToolStripMenuItem
            // 
            this.复制本行ToolStripMenuItem.Name = "复制本行ToolStripMenuItem";
            this.复制本行ToolStripMenuItem.Size = new System.Drawing.Size(152, 28);
            this.复制本行ToolStripMenuItem.Text = "复制内容";
            this.复制本行ToolStripMenuItem.Click += new System.EventHandler(this.复制本行ToolStripMenuItem_Click);
            // 
            // 删除本行ToolStripMenuItem
            // 
            this.删除本行ToolStripMenuItem.Name = "删除本行ToolStripMenuItem";
            this.删除本行ToolStripMenuItem.Size = new System.Drawing.Size(152, 28);
            this.删除本行ToolStripMenuItem.Text = "删除本行";
            this.删除本行ToolStripMenuItem.Click += new System.EventHandler(this.删除本行ToolStripMenuItem_Click);
            // 
            // 刷新列表ToolStripMenuItem1
            // 
            this.刷新列表ToolStripMenuItem1.Name = "刷新列表ToolStripMenuItem1";
            this.刷新列表ToolStripMenuItem1.Size = new System.Drawing.Size(152, 28);
            this.刷新列表ToolStripMenuItem1.Text = "刷新列表";
            this.刷新列表ToolStripMenuItem1.Click += new System.EventHandler(this.刷新列表ToolStripMenuItem1_Click);
            // 
            // tabPage3
            // 
            this.tabPage3.Location = new System.Drawing.Point(4, 28);
            this.tabPage3.Name = "tabPage3";
            this.tabPage3.Size = new System.Drawing.Size(895, 548);
            this.tabPage3.TabIndex = 2;
            this.tabPage3.Text = "我的资料";
            this.tabPage3.UseVisualStyleBackColor = true;
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 18F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(900, 575);
            this.Controls.Add(this.tabControl1);
            this.Margin = new System.Windows.Forms.Padding(4);
            this.MaximizeBox = false;
            this.Name = "MainForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "REDUCE 短网址平台";
            this.Load += new System.EventHandler(this.Main_Load);
            this.tabControl1.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.AppInfoContextMenuStrip.ResumeLayout(false);
            this.tabPage2.ResumeLayout(false);
            this.tabPage2.PerformLayout();
            this.ShortContextMenuStrip.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabPage tabPage2;
        private System.Windows.Forms.TabPage tabPage3;
        private System.Windows.Forms.ListView AppInfoListView;
        private System.Windows.Forms.ColumnHeader columnHeader2;
        private System.Windows.Forms.ColumnHeader columnHeader3;
        private System.Windows.Forms.ColumnHeader columnHeader4;
        private System.Windows.Forms.ColumnHeader columnHeader8;
        private System.Windows.Forms.ColumnHeader columnHeader1;
        private System.Windows.Forms.ContextMenuStrip AppInfoContextMenuStrip;
        private System.Windows.Forms.ToolStripMenuItem 创建应用ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 编辑应用ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 删除应用ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 刷新列表ToolStripMenuItem;
        private System.Windows.Forms.ListView ShortListView;
        private System.Windows.Forms.ColumnHeader columnHeader5;
        private System.Windows.Forms.ColumnHeader columnHeader6;
        private System.Windows.Forms.ColumnHeader columnHeader7;
        private System.Windows.Forms.ColumnHeader columnHeader9;
        private System.Windows.Forms.ColumnHeader columnHeader10;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.LinkLabel PageAddLinkLabel;
        private System.Windows.Forms.LinkLabel PageSubLinkLabel;
        private System.Windows.Forms.ToolStripMenuItem 添加网址ToolStripMenuItem;
        private System.Windows.Forms.ContextMenuStrip ShortContextMenuStrip;
        private System.Windows.Forms.ToolStripMenuItem 复制本行ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 删除本行ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 刷新列表ToolStripMenuItem1;
    }
}