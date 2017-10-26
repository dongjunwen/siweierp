package com.fangxin.siwei.fangzhi.vo.result;

/**
 * @Date:2017/10/26 0026 10:27
 * @Author lu.dong
 * @Description： 菜单资源列表
 *
 * id: string, 唯一id
bpid: string, 面包屑导航的父id
mpid: string, 菜单的父id,缺省时为一级菜单,为-1时在菜单中不显示
name: 显示名称
route: 匹配路由,缺省时不做跳转
 **/
public class SysResourceResultVo {
    /**
     * 唯一id
     */
    private String id;
    /**
     * 面包屑导航的父id
     */
    private String bpid;
    /**
     * 菜单的父id,缺省时为一级菜单,为-1时在菜单中不显示
     */
    private String mpid;
    /**
     * 显示名称
     */
    private String name;
    /**
     *  匹配路由,缺省时不做跳转
     */
    private String route;
    /**
     * 在名称前显示的图标
     */
    private String icon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBpid() {
        return bpid;
    }

    public void setBpid(String bpid) {
        this.bpid = bpid;
    }

    public String getMpid() {
        return mpid;
    }

    public void setMpid(String mpid) {
        this.mpid = mpid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
