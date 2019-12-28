using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Reduce.impl.container
{
    class PagerContainer<T>
    {

        private Int32 count;

        public Int32 Count
        {
            get { return count; }
            set { count = value; }
        }
        private Int32 size = 10;

        public Int32 Size
        {
            get { return size; }
            set { size = value; }
        }
        private Int32 current;

        public Int32 Current
        {
            get { return current; }
            set { current = value; }
        }
        private Int32 total = 1;

        public Int32 Total
        {
            get { return total; }
            set { total = value; }
        }
        private List<T> data;

        public List<T> Data
        {
            get { return data; }
            set { data = value; }
        }
    }
}
