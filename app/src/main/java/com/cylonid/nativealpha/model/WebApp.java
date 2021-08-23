package com.cylonid.nativealpha.model;


import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.cylonid.nativealpha.R;
import com.cylonid.nativealpha.util.Const;
import com.cylonid.nativealpha.util.Utility;

import java.util.Arrays;

public class WebApp {

    private final int ID;
    private String title;
    private String base_url;
    private String last_used_url;
    private Long timestamp_last_used_url;
    private int timeout_last_used_url;
    private boolean override_global_settings;

    private boolean open_url_external;
    private boolean allow_cookies;
    private boolean allow_third_p_cookies;
    private boolean restore_page;
    private boolean allow_js;
    private boolean active_entry;
    private boolean request_desktop;
    private boolean clear_cache;
    private boolean use_adblock;
    private boolean send_savedata_request;
    private boolean block_images;
    private boolean allow_http;
    private String url_on_first_pageload;
    private boolean allow_location_access;
    private String user_agent;
    private boolean use_custom_user_agent;
    private boolean autoreload;
    private int time_autoreload;
    private boolean force_dark_mode;
    private boolean use_timespan_dark_mode;
    private String timespan_dark_mode_begin;
    private String timespan_dark_mode_end;
    private boolean ignore_ssl_errors;
    private boolean show_expert_settings;
    private boolean safe_browsing;
    private boolean block_third_party_requests;
    private double initial_scale_factor;

    public WebApp(String url, int id) {
        title = url.replace("http://", "").replace("https://", "").replace("www.", "");
        base_url = url;
        ID = id;
        override_global_settings = true;
        open_url_external = false;
        active_entry = true;
        timeout_last_used_url = 10;
        last_used_url = null;
        restore_page = true;
        allow_cookies = true;
        allow_third_p_cookies = false;
        allow_js = true;
        request_desktop = false;
        clear_cache = false;
        use_adblock = false;
        send_savedata_request = false;
        block_images = false;
        allow_http = false;
        url_on_first_pageload = null;
        allow_location_access = false;
        user_agent = null;
        use_custom_user_agent = false;
        autoreload = false;
        time_autoreload = 60;
        force_dark_mode = false;
        use_timespan_dark_mode = false;
        timespan_dark_mode_begin = "22:00";
        timespan_dark_mode_end = "06:00";
        ignore_ssl_errors = false;
        show_expert_settings = false;
        safe_browsing = true;
        block_third_party_requests = false;
        initial_scale_factor = 1.0;

        initDefaultSettings();
    }

    public WebApp(WebApp other) {
        this.title = other.title;
        this.base_url = other.base_url;
        this.ID = other.ID;
        this.last_used_url = other.last_used_url;
        this.url_on_first_pageload = other.url_on_first_pageload;
        this.timestamp_last_used_url = other.timestamp_last_used_url;
        this.timeout_last_used_url = other.timeout_last_used_url;
        this.override_global_settings = other.override_global_settings;

        copySettings(other);
    }

    //This part of the copy ctor should be callable independently from actual object construction to copy values of the global web app template
    public void copySettings(WebApp other) {
        this.open_url_external = other.open_url_external;
        this.allow_cookies = other.allow_cookies;
        this.allow_third_p_cookies = other.allow_third_p_cookies;
        this.restore_page = other.restore_page;
        this.allow_js = other.allow_js;
        this.active_entry = other.active_entry;
        this.request_desktop = other.request_desktop;
        this.clear_cache = other.clear_cache;
        this.use_adblock = other.use_adblock;
        this.send_savedata_request = other.send_savedata_request;
        this.block_images = other.block_images;
        this.allow_http = other.allow_http;
        this.allow_location_access = other.allow_location_access;
        this.user_agent = other.user_agent;
        this.use_custom_user_agent = other.use_custom_user_agent;
        this.autoreload = other.autoreload;
        this.time_autoreload = other.time_autoreload;
        this.force_dark_mode = other.force_dark_mode;
        this.use_timespan_dark_mode = other.use_timespan_dark_mode;
        this.timespan_dark_mode_begin = other.timespan_dark_mode_begin;
        this.timespan_dark_mode_end = other.timespan_dark_mode_end;
        this.ignore_ssl_errors = other.ignore_ssl_errors;
        this.show_expert_settings = other.show_expert_settings;
        this.safe_browsing = other.safe_browsing;
        this.block_third_party_requests = other.block_third_party_requests;
        this.initial_scale_factor = other.initial_scale_factor;
    }

    private void initDefaultSettings() {
        if (base_url.contains("facebook.com")) {
            this.user_agent = Const.DESKTOP_USER_AGENT;
            this.use_custom_user_agent = true;
        }
    }

    /*
        This function is used for settings where the ctor needs to have a different setting because
        we want different behaviour for already existing and newly created Web Apps.
            */
    public void applySettingsForNewWebApp() {
        this.override_global_settings = false;
    }

    public boolean isSafeBrowsing() {
        return safe_browsing;
    }

    public void setSafeBrowsing(boolean safeBrowsing) {
        this.safe_browsing = safeBrowsing;
    }

    public boolean isOverrideGlobalSettings() {
        return override_global_settings;
    }

    public void setOverrideGlobalSettings(boolean overrideGlobalSettings) {
        this.override_global_settings = overrideGlobalSettings;
    }

    public boolean isBlockThirdPartyRequests() {
        return block_third_party_requests;
    }

    public void setBlockThirdPartyRequests(boolean blockThirdPartyRequests) {
        this.block_third_party_requests = blockThirdPartyRequests;
    }

    public double getInitialScaleFactor() {
        return initial_scale_factor;
    }

    public void setInitialScaleFactor(double initialScaleFactor) {
        this.initial_scale_factor = initialScaleFactor;
    }

    public boolean isShowExpertSettings() {
        return show_expert_settings;
    }

    public void setShowExpertSettings(boolean showExpertSettings) {
        this.show_expert_settings = showExpertSettings;
    }

    public boolean isIgnoreSslErrors() {
        return ignore_ssl_errors;
    }

    public void setIgnoreSslErrors(boolean ignoreSslErrors) {
        this.ignore_ssl_errors = ignoreSslErrors;
    }

    public boolean isUseTimespanDarkMode() {
        return use_timespan_dark_mode;
    }

    public void setUseTimespanDarkMode(boolean useTimespanDarkMode) {
        this.use_timespan_dark_mode = useTimespanDarkMode;
    }

    public String getTimespanDarkModeBegin() {
        return timespan_dark_mode_begin;
    }

    public void setTimespanDarkModeBegin(String timespanDarkModeBegin) {
        this.timespan_dark_mode_begin = timespanDarkModeBegin;
    }

    public String getTimespanDarkModeEnd() {
        return timespan_dark_mode_end;
    }

    public void setTimespanDarkModeEnd(String timespanDarkModeEnd) {
        this.timespan_dark_mode_end = timespanDarkModeEnd;
    }

    public boolean isAllowHttp() {
        return allow_http;
    }

    public void setAllowHttp(boolean allow_http) {
        this.allow_http = allow_http;
    }

    public boolean isSendSavedataRequest() {
        return send_savedata_request;
    }

    public void setSendSavedataRequest(boolean send_savedata_request) {
        this.send_savedata_request = send_savedata_request;
    }

    public boolean isBlockImages() {
        return block_images;
    }

    public void setBlockImages(boolean block_images) {
        this.block_images = block_images;
    }

    public void markInactive() {
        active_entry = false;
        Utility.deleteShortcuts(Arrays.asList(this.getID()));
        DataManager.getInstance().saveWebAppData();
    }

    public void allowHTTP() {
        allow_http = true;
        DataManager.getInstance().saveWebAppData();
    }

    public void saveCurrentUrl(String url) {
        if (restore_page) {
            last_used_url = url;
            timestamp_last_used_url = System.currentTimeMillis() / 1000;
            DataManager.getInstance().saveWebAppData();
        }
    }

    public String getSingleLineTitle() {
        if (title.length() > 24) {
            String single_line = title.substring(0, 25);
            single_line += " ...";
            return single_line;
        }

        return title;
    }

    public String getLoadableUrl() {

//        LEGACY SETTING: Removed with release 0.86/1.0.0
//        if (last_used_url == null)
//            return base_url;
//        else if (restore_page) {
//
//            long current_time_sec = System.currentTimeMillis() / 1000;
//            long diff = Math.abs(timestamp_last_used_url - current_time_sec);
//            if (diff <= timeout_last_used_url * 60)
//                return last_used_url;
//        }

        return base_url;
    }

    public int getTimeoutLastUsedUrl() {
        return timeout_last_used_url;
    }

    public void setTimeoutLastUsedUrl(int timeout_last_used_url) {
        this.timeout_last_used_url = timeout_last_used_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBaseUrl() {
        return base_url;
    }

    public void setBaseUrl(String base_url) {
        this.base_url = base_url;
        DataManager.getInstance().saveWebAppData();
    }

    public int getID() {
        return ID;
    }

    public boolean isOpenUrlExternal() {
        return open_url_external;
    }

    public void setOpenUrlExternal(boolean open_url_external) {
        this.open_url_external = open_url_external;
    }

    public boolean isActiveEntry() {
        return active_entry;
    }

    public void setActiveEntry(boolean active_entry) {
        this.active_entry = active_entry;
    }

    public boolean isAllowCookies() {
        return allow_cookies;
    }

    public void setAllowCookies(boolean allow_cookies) {
        this.allow_cookies = allow_cookies;
    }

    public boolean isAllowThirdPartyCookies() {
        return allow_third_p_cookies;
    }

    public void setAllowThirdPartyCookies(boolean allow_third_p_cookies) {
        this.allow_third_p_cookies = allow_third_p_cookies;
    }

    public boolean isRestorePage() {
        return restore_page;
    }

    public void setRestorePage(boolean restore_page) {
        this.restore_page = restore_page;
    }

    public boolean isAllowJs() {
        return allow_js;
    }

    public void setAllowJs(boolean allow_js) {
        this.allow_js = allow_js;
    }

    public boolean isRequestDesktop() {
        return request_desktop;
    }

    public void setRequestDesktop(boolean request_desktop) {
        this.request_desktop = request_desktop;
    }

    public boolean isClearCache() {
        return clear_cache;
    }

    public void setClearCache(boolean clear_cache) {
        this.clear_cache = clear_cache;
    }

    public boolean isUseAdblock() {
        return use_adblock;
    }

    public void setUseAdblock(boolean use_adblock) {
        this.use_adblock = use_adblock;
    }

    public boolean isAutoreload() {
        return autoreload;
    }

    public void setAutoreload(boolean autoreload) {
        this.autoreload = autoreload;
    }

    public int getTimeAutoreload() {
        return time_autoreload;
    }

    public void setTimeAutoreload(int time_autoreload) {
        this.time_autoreload = time_autoreload;
    }

    public boolean isAllowLocationAccess() {
        return allow_location_access;
    }

    public void setAllowLocationAccess(boolean allow_location_access) {
        this.allow_location_access = allow_location_access;
    }

    public boolean isForceDarkMode() {
        return force_dark_mode;
    }

    public void setForceDarkMode(boolean forceDarkMode) {
        this.force_dark_mode = forceDarkMode;
    }

    public String getUserAgent() {
        return user_agent;
    }

    public void setUserAgent(String user_agent) {
        this.user_agent = user_agent;
    }

    public boolean isUseCustomUserAgent() {
        return use_custom_user_agent;
    }

    public void setUseCustomUserAgent(boolean use_custom_user_agent) {
        this.use_custom_user_agent = use_custom_user_agent;
    }

    public void enableLocationAccess() {
        this.allow_location_access = true;
        DataManager.getInstance().saveWebAppData();
    }

    public void setLastUsedUrl(String last_used_url) {
        this.last_used_url = last_used_url;
    }

    public void setTimestampLastUsedUrl(Long timestamp_last_used_url) {
        this.timestamp_last_used_url = timestamp_last_used_url;
    }

    public String getNonNullUrlOnFirstPageload() {
        if (url_on_first_pageload != null)
            return url_on_first_pageload;

        return base_url;
    }

    public String getUrlOnFirstPageload() {
        return url_on_first_pageload;
    }


    public void saveUrlOnFirstPageLoad(String url) {
        url_on_first_pageload = url;
        DataManager.getInstance().saveWebAppData();
    }

    public String getDomain() {
        return base_url.replace("http://", "").replace("https://", "").replace("www.", "");
    }


    public void onSwitchCookiesChanged(CompoundButton mSwitch, boolean isChecked) {
        Switch third_party_cookies = mSwitch.getRootView().findViewById(R.id.switch3PCookies);
        if (isChecked)
            third_party_cookies.setEnabled(true);
        else {
            third_party_cookies.setEnabled(false);
            third_party_cookies.setChecked(false);
        }
    }

    public void onSwitchJsChanged(CompoundButton mSwitch, boolean isChecked) {
        Switch switchDesktopVersion = mSwitch.getRootView().findViewById(R.id.switchDesktopSite);
        Switch switchAdblock = mSwitch.getRootView().findViewById(R.id.switchAdblock);
        if (isChecked) {
            switchDesktopVersion.setEnabled(true);
            switchAdblock.setEnabled(true);
        } else {
            switchDesktopVersion.setChecked(false);
            switchDesktopVersion.setEnabled(false);
            switchAdblock.setChecked(false);
            switchAdblock.setEnabled(false);
        }
    }

    public void onSwitchForceDarkChanged(CompoundButton mSwitch, boolean isChecked) {
        Switch switchLimit = mSwitch.getRootView().findViewById(R.id.switchTimeSpanDarkMode);
        EditText txtBegin = mSwitch.getRootView().findViewById(R.id.textDarkModeBegin);
        EditText txtEnd = mSwitch.getRootView().findViewById(R.id.textDarkModeEnd);
        if (isChecked) {
            switchLimit.setEnabled(true);

        } else {
            switchLimit.setChecked(false);
            switchLimit.setEnabled(false);
        }
    }

    public void onSwitchTimeSpanDarkChanged(CompoundButton mSwitch, boolean isChecked) {
        TextView lblBegin = mSwitch.getRootView().findViewById(R.id.lblDarkModeBegin);
        TextView lblEnd = mSwitch.getRootView().findViewById(R.id.lblDarkModeEnd);
        EditText txtBegin = mSwitch.getRootView().findViewById(R.id.textDarkModeBegin);
        EditText txtEnd = mSwitch.getRootView().findViewById(R.id.textDarkModeEnd);
        if (isChecked) {
            lblBegin.setEnabled(true);
            lblEnd.setEnabled(true);
            txtBegin.setEnabled(true);
            txtEnd.setEnabled(true);
        } else {
            lblBegin.setEnabled(false);
            lblEnd.setEnabled(false);
            txtBegin.setEnabled(false);
            txtEnd.setEnabled(false);
        }
    }

    public void onSwitchRestorePageChanged(CompoundButton mSwitch, boolean isChecked) {
        EditText textTimeout = mSwitch.getRootView().findViewById(R.id.textTimeout);
        textTimeout.setEnabled(isChecked);
    }

    public void onSwitchUserAgentChanged(CompoundButton mSwitch, boolean isChecked) {
        EditText txt = mSwitch.getRootView().findViewById(R.id.textUserAgent);
        Switch switchDesktopVersion = mSwitch.getRootView().findViewById(R.id.switchDesktopSite);
        if (isChecked) {
            switchDesktopVersion.setChecked(false);
            switchDesktopVersion.setEnabled(false);
            txt.setEnabled(true);

        } else {
            txt.setEnabled(false);
            switchDesktopVersion.setEnabled(true);
        }

    }

    public void onSwitchAutoreloadChanged(CompoundButton mSwitch, boolean isChecked) {
        EditText text = mSwitch.getRootView().findViewById(R.id.textReloadInterval);
        TextView label = mSwitch.getRootView().findViewById(R.id.labelReloadInterval);
        text.setEnabled(isChecked);
        label.setEnabled(isChecked);
    }

    public void onSwitchExpertSettingsChanged(CompoundButton mSwitch, boolean isChecked) {
        LinearLayout expertSettings = mSwitch.getRootView().findViewById(R.id.sectionExpertSettings);

        if (isChecked)
            expertSettings.setVisibility(View.VISIBLE);
        else
            expertSettings.setVisibility(View.GONE);
    }

    public void onSwitchOverrideGlobalSettingsChanged(CompoundButton mSwitch, boolean isChecked) {
        LinearLayout sectionDetailedWebAppSettings = mSwitch.getRootView().findViewById(R.id.sectionWebAppDetailSettings);
        Utility.setViewAndChildrenEnabled(sectionDetailedWebAppSettings, isChecked);
    }
}
