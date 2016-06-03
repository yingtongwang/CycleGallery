# CycleGallery
画廊循环滑动，可以左右滑动
@Override
    public int getCount() {
        /**
         * 个数设为默认最大值
         */
        return Integer.MAX_VALUE;
    }

    @Override
    public Object getItem(int position) {
        if (position >= imgs.length) {
            position = position % imgs.length;
        }

        return position;
    }

    @Override
    public long getItemId(int position) {
        if (position >= imgs.length) {
            position = position % imgs.length;
        }
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /**
         * 按照position % imgs.length返回ImageView
         */
        return mImageViewList[position % imgs.length];

    }
