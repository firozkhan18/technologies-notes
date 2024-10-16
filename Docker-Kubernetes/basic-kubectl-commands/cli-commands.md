### install hyperhit and minikube
`brew update`

`brew install hyperkit`

`brew install minikube`

`kubectl`

`minikube`

### create minikube cluster
`minikube start --vm-driver=hyperkit`

`kubectl get nodes`

`minikube status`

`kubectl version`

### delete cluster and restart in debug mode
`minikube delete`

`minikube start --vm-driver=hyperkit --v=7 --alsologtostderr`

`minikube status`

### kubectl commands
`kubectl get nodes`

`kubectl get pod`

`kubectl get services`

`kubectl create deployment nginx-depl --image=nginx`

`kubectl get deployment`

`kubectl get replicaset`

`kubectl edit deployment nginx-depl`

### debugging
`kubectl logs {pod-name}`

`kubectl exec -it {pod-name} -- bin/bash`

### create mongo deployment
`kubectl create deployment mongo-depl --image=mongo`

`kubectl logs mongo-depl-{pod-name}`

`kubectl describe pod mongo-depl-{pod-name}`

### delete deployment
`kubectl delete deployment mongo-depl`

`kubectl delete deployment nginx-depl`

### create or edit config file
`vim nginx-deployment.yaml`

`kubectl apply -f nginx-deployment.yaml`

`kubectl get pod`

`kubectl get deployment`

### delete with config
`kubectl delete -f nginx-deployment.yaml`

#Metrics

`kubectl top` The kubectl top command returns current CPU and memory usage for a cluster’s pods or nodes, or for a particular pod or node if specified.



-a----        17-11-2023     23:49         184832 iasrecst.dll
-a----        17-11-2023     23:49         263680 iassam.dll
-a----        17-11-2023     23:49         464384 iassdo.dll
-a----        15-07-2024     15:48         145408 iassvcs.dll
-a----        12-10-2021     06:12         220352 iaStorAfsNative.exe
-a----        12-10-2021     06:12        3031232 iaStorAfsService.exe
-a----        07-12-2019     14:39          39424 icacls.exe
-a----        15-07-2024     15:47         120192 icfupgd.dll
-a----        15-07-2024     15:47         262144 icm32.dll
-a----        07-12-2019     14:39           3072 icmp.dll
-a----        07-12-2019     14:38          28160 icmui.dll
-a----        07-12-2019     14:38          14336 IconCodecService.dll
-a----        15-07-2024     15:46          37888 IcsEntitlementHost.exe
-a----        07-12-2019     14:39          70656 icsigd.dll
-a----        15-07-2024     15:47          15872 icsunattend.exe
-a----        15-07-2024     15:49         294256 icsvc.dll
-a----        15-07-2024     15:49         304640 icsvcext.dll
-a----        29-10-2023     08:35        2260480 icu.dll
-a----        03-12-2020     22:33          25088 icuin.dll
-a----        03-12-2020     22:33          29696 icuuc.dll
-a----        15-07-2024     15:47         119808 IdCtrls.dll
-a----        07-12-2019     14:39          60458 ideograf.uce
-a----        17-11-2023     23:49         202240 IdListen.dll
-a----        07-12-2019     14:38          10240 idndl.dll
-a----        15-07-2024     15:46         185856 IDStore.dll
-a----        15-07-2024     15:48         263680 ie4uinit.exe
-a----        15-07-2024     15:48          96256 ie4ushowIE.exe
-a----        15-07-2024     15:48         151552 IEAdvpack.dll
-a----        15-07-2024     15:48         886784 ieapfltr.dll
-a----        15-07-2024     15:48         413184 iedkcs32.dll
-a----        15-07-2024     15:48        7740928 ieframe.dll
-a----        15-07-2024     15:48          65536 iemigplugin.dll
-a----        17-11-2023     23:49         145920 iepeers.dll
-a----        20-01-2024     11:02         957440 ieproxy.dll
-a----        15-07-2024     15:48          48128 iernonce.dll
-a----        15-07-2024     15:47        2868712 iertutil.dll
-a----        15-07-2024     15:48         546304 IESettingSync.exe
-a----        15-07-2024     15:48          79872 iesetup.dll
-a----        15-07-2024     15:48          47616 iesysprep.dll
-a----        17-11-2023     23:49         572416 ieui.dll
-a----        07-12-2019     14:39           3329 ieuinit.inf
-a----        15-07-2024     15:48         158720 ieUnatt.exe
-a----        07-12-2019     14:39         170496 iexpress.exe
-a----        07-12-2019     14:39          32256 ifmon.dll
-a----        17-11-2023     23:48         227712 ifsutil.dll
-a----        07-12-2019     14:39          16896 ifsutilx.dll
-a----        17-11-2023     23:49          89088 igdDiag.dll
-a----        15-07-2024     15:46         198144 IHDS.dll
-a----        07-12-2019     14:39          64512 ihvrilproxy.dll
-a----        22-03-2024     13:02        1049088 IKEEXT.DLL
-a----        17-11-2023     23:47          38432 imaadp32.acm
-a----        17-11-2023     23:48         108608 imagehlp.dll
-a----        15-07-2024     15:46           2560 imageres.dll
-a----        07-12-2019     14:38           2560 imagesp1.dll
-a----        15-07-2024     15:48         169472 imapi.dll
-a----        17-11-2023     23:49         519168 imapi2.dll
-a----        17-11-2023     23:49        1005568 imapi2fs.dll
-a----        17-11-2023     23:49          58368 imgutil.dll
-a----        15-07-2024     15:47         184432 imm32.dll
-a----        15-07-2024     15:47         144384 immersivetpmvscmgrsvr.exe
-a----        15-07-2024     15:47         136560 ImplatSetup.dll
-a----        15-07-2024     15:48         237056 IndexedDbLegacy.dll
-a----        15-07-2024     15:48        1029632 inetcomm.dll
-a----        15-07-2024     15:48         563200 inetcpl.cpl
-a----        07-12-2019     14:39          68608 inetmib1.dll
-a----        15-07-2024     15:49         186880 inetpp.dll
-a----        15-07-2024     15:49          35328 inetppui.dll
-a----        17-11-2023     23:49          85504 INETRES.dll
-a----        07-12-2019     14:39          13824 InfDefaultInstall.exe
-a----        17-11-2023     23:49         273920 InkEd.dll
-a----        17-11-2023     23:48         955392 InkObjCore.dll
-a----        15-07-2024     15:49          60928 InprocLogger.dll
-a----        15-07-2024     15:47         379376 input.dll
-a----        15-07-2024     15:47         231424 InputCloudStore.dll
-a----        17-11-2023     23:49          69632 InputController.dll
-a----        15-07-2024     15:47        1379128 InputHost.dll
-a----        15-07-2024     15:46         136192 InputInjectionBroker.dll
-a----        15-07-2024     15:47         142336 InputLocaleManager.dll
-a----        15-07-2024     15:47        4794368 InputService.dll
-a----        15-07-2024     15:47         536576 InputSwitch.dll
-a----        15-07-2024     15:47          86528 InputSwitchToastHandler.exe
-a----        07-12-2019     14:38           1284 InputSystemToastIcon.contrast-white.png
-a----        07-12-2019     14:38            917 InputSystemToastIcon.png
-a----        15-07-2024     15:48         120832 inseng.dll
-a----        15-07-2024     15:47        2491904 InstallService.dll
-a----        15-07-2024     15:47         250368 InstallServiceTasks.dll
-a----        15-07-2024     15:46          21724 IntegratedServicesRegionPolicySet.json
-a----        02-08-2021     19:21         173088 intel_gfx_api-x64.dll
-a----        15-07-2024     15:49         723456 internetmail.dll
-a----        15-07-2024     15:49          97280 InternetMailCsp.dll
-a----        15-07-2024     15:47         238592 intl.cpl
-a----        15-07-2024     15:47         607712 invagent.dll
-a----        07-12-2019     14:38           2560 iologmsg.dll
-a----        07-12-2019     14:39          35840 ipconfig.exe
-a----        07-12-2019     14:38          75776 IPELoggingDictationHelper.dll
-a----        17-11-2023     23:48         231560 IPHLPAPI.DLL
-a----        15-07-2024     15:47         836608 iphlpsvc.dll
-a----        15-07-2024     15:47         654336 ipnathlp.dll
-a----        07-12-2019     14:39          32768 IpNatHlpClient.dll
-a----        15-07-2024     15:47         112128 IppCommon.dll
-a----        22-03-2024     13:02          17920 IppCommonProxy.dll
-a----        20-01-2024     11:02          11776 iprtprio.dll
-a----        15-07-2024     15:47         629760 iprtrmgr.dll
-a----        17-11-2023     23:48         422912 ipsecsnp.dll
-a----        17-11-2023     23:48         463360 IPSECSVC.DLL
-a----        17-11-2023     23:48         532480 ipsmsnap.dll
-a----        07-12-2019     14:38          66048 ipxlatcfg.dll
-a----        17-11-2023     23:48          52224 iri.dll
-a----        07-12-2019     14:39          37376 irprops.cpl
-a----        15-07-2024     15:48          50688 iscsicli.exe
-a----        07-12-2019     14:39         109568 iscsicpl.dll
-a----        07-12-2019     14:39          12800 iscsicpl.exe
-a----        15-07-2024     15:48          79872 iscsidsc.dll
-a----        15-07-2024     15:48          12800 iscsied.dll
-a----        15-07-2024     15:48         165888 iscsiexe.dll
-a----        17-11-2023     23:47          16896 iscsilog.dll
-a----        15-07-2024     15:48          37376 iscsium.dll
-a----        15-07-2024     15:48          84480 iscsiwmi.dll
-a----        15-07-2024     15:48         131072 iscsiwmiv2.dll
-a----        15-07-2024     15:47        2252288 ISM.dll
-a----        15-07-2024     15:48         122368 isoburn.exe
-a----        17-11-2023     23:49         205824 itircl.dll
-a----        07-12-2019     14:39         177152 itss.dll
-a----        15-07-2024     15:47          53904 iuilp.dll
-a----        17-11-2023     23:49          27040 iumbase.dll
-a----        15-07-2024     15:47          70808 iumcrypt.dll
-a----        17-11-2023     23:49          16728 iumdll.dll
-a----        07-12-2019     14:39          22624 IumSdk.dll
-a----        07-12-2019     14:39          54272 iyuv_32.dll
-a----        17-11-2023     23:49          90624 JavaScriptCollectionAgent.dll
-a----        30-11-2020     03:28         337288 JHI64.dll
-a----        17-11-2023     23:49          60416 joinproviderol.dll
-a----        17-11-2023     23:49         151552 joinutil.dll
-a----        07-12-2019     14:39          99328 joy.cpl
-a----        15-07-2024     15:47         700416 JpMapControl.dll
-a----        15-07-2024     15:46         381440 jpndecoder.dll
-a----        15-07-2024     15:46          81408 jpninputrouter.dll
-a----        15-07-2024     15:46         297472 jpnranker.dll
-a----        15-07-2024     15:47         245760 JpnServiceDS.dll
-a----        15-07-2024     15:48         854016 jscript.dll
-a----        15-07-2024     15:48        4887040 jscript9.dll
-a----        15-07-2024     15:48         714752 jscript9diag.dll
-a----        17-11-2023     23:48          53248 jsproxy.dll
-a----        07-12-2019     14:39           6948 kanji_1.uce
-a----        07-12-2019     14:39           8484 kanji_2.uce
-a----        17-11-2023     23:48           8704 kbd101.dll
-a----        07-12-2019     14:38           8192 kbd101a.dll
-a----        07-12-2019     14:38           8192 kbd101b.dll
-a----        07-12-2019     14:38           8192 kbd101c.dll
-a----        07-12-2019     14:38           8192 kbd103.dll
-a----        17-11-2023     23:48           8704 kbd106.dll
-a----        17-11-2023     23:48           8704 kbd106n.dll
-a----        07-12-2019     14:38           7680 KBDA1.DLL
-a----        07-12-2019     14:38           7680 KBDA2.DLL
-a----        07-12-2019     14:38           8192 KBDA3.DLL
-a----        07-12-2019     14:38           8192 KBDADLM.DLL
-a----        07-12-2019     14:38           8192 KBDAL.DLL
-a----        07-12-2019     14:38           7168 KBDARME.DLL
-a----        07-12-2019     14:38           8192 kbdarmph.dll
-a----        07-12-2019     14:38           8192 kbdarmty.dll
-a----        07-12-2019     14:38           7168 KBDARMW.DLL
-a----        07-12-2019     14:38           8704 kbdax2.dll
-a----        07-12-2019     14:38           8192 KBDAZE.DLL
-a----        07-12-2019     14:38           7680 KBDAZEL.DLL
-a----        07-12-2019     14:38           7680 KBDAZST.DLL
-a----        07-12-2019     14:38           7680 KBDBASH.DLL
-a----        07-12-2019     14:38           8192 KBDBE.DLL
-a----        07-12-2019     14:38           8192 KBDBENE.DLL
-a----        07-12-2019     14:38           7680 KBDBGPH.DLL
-a----        07-12-2019     14:38           8192 KBDBGPH1.DLL
-a----        07-12-2019     14:38           8192 KBDBHC.DLL
-a----        07-12-2019     14:38           7680 KBDBLR.DLL
-a----        07-12-2019     14:38           8192 KBDBR.DLL
-a----        07-12-2019     14:38           7680 KBDBU.DLL
-a----        07-12-2019     14:38           7680 KBDBUG.DLL
-a----        07-12-2019     14:38           7680 KBDBULG.DLL
-a----        07-12-2019     14:38           8192 KBDCA.DLL
-a----        07-12-2019     14:38           9728 KBDCAN.DLL
-a----        07-12-2019     14:38           8192 KBDCHER.DLL
-a----        07-12-2019     14:38          17920 KBDCHERP.DLL
-a----        07-12-2019     14:38           8704 KBDCR.DLL
-a----        07-12-2019     14:38           8704 KBDCZ.DLL
-a----        07-12-2019     14:38           9216 KBDCZ1.DLL
-a----        07-12-2019     14:38           8704 KBDCZ2.DLL
-a----        07-12-2019     14:38           7680 KBDDA.DLL
-a----        07-12-2019     14:38           7680 KBDDIV1.DLL
-a----        07-12-2019     14:38           7680 KBDDIV2.DLL
-a----        07-12-2019     14:38           7680 KBDDV.DLL
-a----        07-12-2019     14:38           8192 KBDDZO.DLL
-a----        07-12-2019     14:38           8704 KBDES.DLL
-a----        07-12-2019     14:38           8192 KBDEST.DLL
-a----        07-12-2019     14:38           7168 KBDFA.DLL
-a----        07-12-2019     14:38           8192 kbdfar.dll
-a----        07-12-2019     14:38           8704 KBDFC.DLL
-a----        07-12-2019     14:38           7680 KBDFI.DLL
-a----        07-12-2019     14:38           9216 KBDFI1.DLL
-a----        07-12-2019     14:38           7680 KBDFO.DLL
-a----        07-12-2019     14:38           7680 KBDFR.DLL
-a----        07-12-2019     14:38           8192 KBDFTHRK.DLL
-a----        07-12-2019     14:38           7680 KBDGAE.DLL
-a----        07-12-2019     14:38           7680 KBDGEO.DLL
-a----        07-12-2019     14:38           8192 kbdgeoer.dll
-a----        07-12-2019     14:38           7680 kbdgeome.dll
-a----        07-12-2019     14:38           8192 kbdgeooa.dll
-a----        07-12-2019     14:38           7680 kbdgeoqw.dll
-a----        07-12-2019     14:38           8704 KBDGKL.DLL
-a----        07-12-2019     14:38           8192 KBDGN.DLL
-a----        07-12-2019     14:38           7680 KBDGR.DLL
-a----        07-12-2019     14:38           8704 KBDGR1.DLL
-a----        07-12-2019     14:38           9216 KBDGRLND.DLL
-a----        07-12-2019     14:38           8192 KBDGTHC.DLL
-a----        07-12-2019     14:38           7680 KBDHAU.DLL
-a----        07-12-2019     14:38           8192 KBDHAW.DLL
-a----        07-12-2019     14:38           7680 KBDHE.DLL
-a----        07-12-2019     14:38           8192 KBDHE220.DLL
-a----        07-12-2019     14:38           8192 KBDHE319.DLL
-a----        07-12-2019     14:38           7680 KBDHEB.DLL
-a----        07-12-2019     14:38           8192 kbdhebl3.dll
-a----        07-12-2019     14:38           8192 KBDHELA2.DLL
-a----        07-12-2019     14:38           8192 KBDHELA3.DLL
-a----        07-12-2019     14:38          10752 KBDHEPT.DLL
-a----        07-12-2019     14:38           8704 KBDHU.DLL
-a----        07-12-2019     14:38           7680 KBDHU1.DLL
-a----        07-12-2019     14:38           8704 kbdibm02.dll
-a----        07-12-2019     14:38           8192 KBDIBO.DLL
-a----        07-12-2019     14:38           7680 KBDIC.DLL
-a----        07-12-2019     14:38           7680 KBDINASA.DLL
-a----        07-12-2019     14:38           7680 KBDINBE1.DLL
-a----        07-12-2019     14:38           7680 KBDINBE2.DLL
-a----        07-12-2019     14:38           8192 KBDINBEN.DLL
-a----        07-12-2019     14:38           8192 KBDINDEV.DLL
-a----        07-12-2019     14:38           9216 KBDINEN.DLL
-a----        07-12-2019     14:38           8192 KBDINGUJ.DLL
-a----        07-12-2019     14:38           8192 KBDINHIN.DLL
-a----        07-12-2019     14:38           8192 KBDINKAN.DLL
-a----        07-12-2019     14:38           8192 KBDINMAL.DLL
-a----        07-12-2019     14:38           8192 KBDINMAR.DLL
-a----        07-12-2019     14:38           8192 KBDINORI.DLL
-a----        07-12-2019     14:38           8192 KBDINPUN.DLL
-a----        07-12-2019     14:38           8192 KBDINTAM.DLL
-a----        07-12-2019     14:38           8192 KBDINTEL.DLL
-a----        07-12-2019     14:38           9216 KBDINUK2.DLL
-a----        07-12-2019     14:38           7168 KBDIR.DLL
-a----        07-12-2019     14:38           7168 KBDIT.DLL
-a----        07-12-2019     14:38           7680 KBDIT142.DLL
-a----        07-12-2019     14:38           8704 KBDIULAT.DLL
-a----        07-12-2019     14:38           8192 KBDJAV.DLL
-a----        17-11-2023     23:48          16384 KBDJPN.DLL
-a----        07-12-2019     14:38           7680 KBDKAZ.DLL
-a----        07-12-2019     14:38           8192 KBDKHMR.DLL
-a----        07-12-2019     14:38           8192 KBDKNI.DLL
-a----        07-12-2019     14:38          15872 KBDKOR.DLL
-a----        07-12-2019     14:38           8192 KBDKURD.DLL
-a----        07-12-2019     14:38           7168 KBDKYR.DLL
-a----        07-12-2019     14:38           8192 KBDLA.DLL
-a----        07-12-2019     14:38           8192 KBDLAO.DLL
-a----        07-12-2019     14:38           7680 kbdlisub.dll
-a----        07-12-2019     14:38           7680 kbdlisus.dll
-a----        07-12-2019     14:38           8704 kbdlk41a.dll
-a----        07-12-2019     14:38           7168 KBDLT.DLL
-a----        07-12-2019     14:38           7680 KBDLT1.DLL
-a----        07-12-2019     14:38           7680 KBDLT2.DLL
-a----        07-12-2019     14:38           7680 KBDLV.DLL
-a----        07-12-2019     14:38           8192 KBDLV1.DLL
-a----        07-12-2019     14:38           9216 KBDLVST.DLL
-a----        07-12-2019     14:38           7680 KBDMAC.DLL
-a----        07-12-2019     14:38           7680 KBDMACST.DLL
-a----        07-12-2019     14:38           7680 KBDMAORI.DLL
-a----        07-12-2019     14:38           8192 KBDMLT47.DLL
-a----        07-12-2019     14:38           8192 KBDMLT48.DLL
-a----        07-12-2019     14:38           7680 KBDMON.DLL
-a----        07-12-2019     14:38           7680 KBDMONMO.DLL
-a----        07-12-2019     14:38           7680 KBDMONST.DLL
-a----        07-12-2019     14:38           8192 KBDMYAN.DLL
-a----        07-12-2019     14:38           7680 KBDNE.DLL
-a----        07-12-2019     14:38           8704 kbdnec.dll
-a----        07-12-2019     14:38           9216 kbdnec95.dll
-a----        07-12-2019     14:38          10752 kbdnecat.dll
-a----        07-12-2019     14:38           9216 kbdnecnt.dll
-a----        07-12-2019     14:38           8192 KBDNEPR.DLL
-a----        07-12-2019     14:38           7168 kbdnko.dll
-a----        07-12-2019     14:38           7680 KBDNO.DLL
-a----        07-12-2019     14:38           9216 KBDNO1.DLL
-a----        07-12-2019     14:38           8704 KBDNSO.DLL
-a----        07-12-2019     14:38           8192 KBDNTL.DLL
-a----        07-12-2019     14:38           7680 KBDOGHAM.DLL
-a----        07-12-2019     14:38           7680 KBDOLCH.DLL
-a----        07-12-2019     14:38           7680 KBDOLDIT.DLL
-a----        07-12-2019     14:38           8192 KBDOSA.DLL
-a----        07-12-2019     14:38           7680 KBDOSM.DLL
-a----        07-12-2019     14:38           7680 KBDPASH.DLL
-a----        07-12-2019     14:38           8192 kbdphags.dll
-a----        07-12-2019     14:38           8704 KBDPL.DLL
-a----        07-12-2019     14:38           8192 KBDPL1.DLL
-a----        07-12-2019     14:38           8192 KBDPO.DLL
-a----        07-12-2019     14:38           9216 KBDRO.DLL
-a----        07-12-2019     14:38           9728 KBDROPR.DLL
-a----        07-12-2019     14:38           9728 KBDROST.DLL
-a----        07-12-2019     14:38           7680 KBDRU.DLL
-a----        07-12-2019     14:38           8192 KBDRU1.DLL
-a----        07-12-2019     14:38           9216 KBDRUM.DLL
-a----        07-12-2019     14:38           8192 KBDSF.DLL
-a----        07-12-2019     14:38           8704 KBDSG.DLL
-a----        07-12-2019     14:38           8192 KBDSL.DLL
-a----        07-12-2019     14:38           9216 KBDSL1.DLL
-a----        07-12-2019     14:38           9216 KBDSMSFI.DLL
-a----        07-12-2019     14:38           9216 KBDSMSNO.DLL
-a----        07-12-2019     14:38           7680 KBDSN1.DLL
-a----        07-12-2019     14:38           7680 KBDSORA.DLL
-a----        07-12-2019     14:38           8704 KBDSOREX.DLL
-a----        07-12-2019     14:38           8192 KBDSORS1.DLL
-a----        07-12-2019     14:38           8704 KBDSORST.DLL
-a----        07-12-2019     14:38           8192 KBDSP.DLL
-a----        07-12-2019     14:38           8192 KBDSW.DLL
-a----        07-12-2019     14:38           8704 KBDSW09.DLL
-a----        07-12-2019     14:38           8192 KBDSYR1.DLL
-a----        07-12-2019     14:38           8192 KBDSYR2.DLL
-a----        07-12-2019     14:38           8192 KBDTAILE.DLL
-a----        07-12-2019     14:38           7680 KBDTAJIK.DLL
-a----        07-12-2019     14:38           7680 KBDTAM99.DLL
-a----        07-12-2019     14:38           8192 KBDTAT.DLL
-a----        07-12-2019     14:38           7680 KBDTH0.DLL
-a----        07-12-2019     14:38           7680 KBDTH1.DLL
-a----        07-12-2019     14:38           7680 KBDTH2.DLL
-a----        07-12-2019     14:38           7680 KBDTH3.DLL
-a----        07-12-2019     14:38           8192 KBDTIFI.DLL
-a----        07-12-2019     14:38           8192 KBDTIFI2.DLL
-a----        07-12-2019     14:38           8704 KBDTIPRC.DLL
-a----        07-12-2019     14:38           8704 KBDTIPRD.DLL
-a----        07-12-2019     14:38           8192 KBDTT102.DLL
-a----        07-12-2019     14:38           8704 KBDTUF.DLL
-a----        07-12-2019     14:38           8704 KBDTUQ.DLL
-a----        07-12-2019     14:38           7680 KBDTURME.DLL
-a----        07-12-2019     14:38           8704 KBDTZM.DLL
-a----        07-12-2019     14:38           7680 KBDUGHR.DLL
-a----        07-12-2019     14:38           7680 KBDUGHR1.DLL
-a----        07-12-2019     14:38           7680 KBDUK.DLL
-a----        07-12-2019     14:38           8704 KBDUKX.DLL
-a----        07-12-2019     14:38           7168 KBDUR.DLL
-a----        07-12-2019     14:38           8192 KBDUR1.DLL
-a----        07-12-2019     14:38           7168 KBDURDU.DLL
-a----        17-11-2023     23:48           9728 KBDUS.DLL
-a----        07-12-2019     14:38           7680 KBDUSA.DLL
-a----        07-12-2019     14:38           7680 KBDUSL.DLL
-a----        07-12-2019     14:38           7680 KBDUSR.DLL
-a----        07-12-2019     14:38           8192 KBDUSX.DLL
-a----        07-12-2019     14:38           7680 KBDUZB.DLL
-a----        07-12-2019     14:38           7680 KBDVNTC.DLL
-a----        07-12-2019     14:38           8192 KBDWOL.DLL
-a----        07-12-2019     14:38           8192 KBDYAK.DLL
-a----        07-12-2019     14:38           8192 KBDYBA.DLL
-a----        07-12-2019     14:38           8192 KBDYCC.DLL
-a----        07-12-2019     14:38           9216 KBDYCL.DLL
-a----        07-12-2019     14:38          15672 kd.dll
-a----        07-12-2019     14:38          29712 kdcom.dll
-a----        15-07-2024     15:46          56832 kdcpw.dll
-a----        15-07-2024     15:48          22504 kdhvcom.dll
-a----        23-02-2024     23:40         126944 kdnet.dll
-a----        17-11-2023     23:49          18920 kdnet_uart16550.dll
-a----        23-02-2024     23:40          89600 KdsCli.dll
-a----        17-11-2023     23:48          28648 kdstub.dll
-a----        07-12-2019     14:39          45368 kdusb.dll
-a----        17-11-2023     23:49          32744 kd_02_10df.dll
-a----        17-11-2023     23:49         380376 kd_02_10ec.dll
-a----        17-11-2023     23:49          27624 kd_02_1137.dll
-a----        17-11-2023     23:49         241112 kd_02_14e4.dll
-a----        17-11-2023     23:49          45552 kd_02_15b3.dll
-a----        17-11-2023     23:49          45544 kd_02_1969.dll
-a----        17-11-2023     23:49          32728 kd_02_19a2.dll
-a----        17-11-2023     23:49          21480 kd_02_1af4.dll
-a----        17-11-2023     23:49         299496 kd_02_8086.dll
-a----        17-11-2023     23:49          19936 kd_07_1415.dll
-a----        17-11-2023     23:49          50144 kd_0C_8086.dll
-a----        17-11-2023     23:48          72192 keepaliveprovider.dll
-a----        15-07-2024     15:47         210312 KerbClientShared.dll
-a----        15-07-2024     15:47        1106944 kerberos.dll
-a----        20-01-2024     11:02          61528 kernel.appcore.dll
-a----        15-07-2024     15:47         781672 kernel32.dll
-a----        15-07-2024     15:47        3114048 KernelBase.dll
-a----        07-12-2019     14:38            841 KeyboardSystemToastIcon.contrast-white.png
-a----        07-12-2019     14:38            523 KeyboardSystemToastIcon.png
-a----        15-07-2024     15:47          71680 KeyCredMgr.dll
-a----        15-07-2024     15:47          99328 keyiso.dll
-a----        17-11-2023     23:49          59904 keymgr.dll
-a----        15-07-2024     15:47         125440 KeywordDetectorMsftSidAdapter.dll
-a----        15-07-2024     15:48          76288 klist.exe
-a----        07-12-2019     14:39          49152 kmddsp.tsp
-a----        15-07-2024     15:46         237568 KnobsCore.dll
-a----        17-11-2023     23:47         125952 KnobsCsp.dll
-a----        07-12-2019     14:39          12876 korean.uce
-a----        17-11-2023     23:49          40448 ksetup.exe
-a----        15-07-2024     15:48         304128 ksproxy.ax
-a----        07-12-2019     14:39         104960 kstvtune.ax
-a----        07-12-2019     14:38          23264 ksuser.dll
-a----        07-12-2019     14:39         141312 Kswdmcap.ax
-a----        07-12-2019     14:39          67584 ksxbar.ax
-a----        07-12-2019     14:39          18944 ktmutil.exe
-a----        17-11-2023     23:48          25088 ktmw32.dll
-a----        07-12-2019     14:38          72192 l2gpstore.dll
-a----        07-12-2019     14:38          63488 l2nacp.dll
-a----        15-07-2024     15:46         203264 L2SecHC.dll
-a----        07-12-2019     15:22          93184 l3codeca.acm
-a----        07-12-2019     15:22         184320 l3codecp.acm
-a----        07-12-2019     14:39          17920 label.exe
-a----        17-11-2023     23:48          16896 LangCleanupSysprepAction.dll
-a----        15-07-2024     15:47         181248 LanguageComponentsInstaller.dll
-a----        15-07-2024     15:47          52736 LanguageComponentsInstallerComHandler.exe
-a----        15-07-2024     15:46         410112 LanguageOverlayServer.dll
-a----        15-07-2024     15:46         253280 LanguageOverlayUtil.dll
-a----        15-07-2024     15:47          80384 LanguagePackDiskCleanup.dll
-a----        15-07-2024     15:46         101888 LanguagePackManagementCSP.dll
-a----        07-12-2019     15:22          13312 LAPRXY.DLL
-a----        15-07-2024     15:47         311296 laps.dll
-a----        15-07-2024     15:47         122368 lapscsp.dll
-a----        07-12-2019     14:38         190760 LaptopPlugInToastImg.gif
-a----        07-12-2019     14:38         149056 LargeRoom.bin
-a----        15-07-2024     15:47          11776 LaunchTM.exe
-a----        15-07-2024     15:47          45056 LaunchWinApp.exe
-a----        07-12-2019     14:39         211938 lcphrase.tbl
-a----        07-12-2019     14:39          24114 lcptr.tbl
-a----        17-11-2023     23:48          69632 LegacyNetUX.dll
-a----        15-07-2024     15:47         243712 LegacyNetUXHost.exe
-a----        15-07-2024     15:47          69632 LegacySystemSettings.dll
-a----        15-07-2024     15:47          48640 lfsvc.dll
-a----        15-05-2021     09:29        1687040 libcrypto.dll
-a----        02-08-2021     19:22         309664 libmfxhw64.dll
-a----        07-12-2019     15:18         138303 license.rtf
-a----        15-07-2024     15:47        1087872 LicenseManager.dll
-a----        15-07-2024     15:47          97280 LicenseManagerApi.dll
-a----        15-07-2024     15:47          48128 LicenseManagerShellext.exe
-a----        15-07-2024     15:47          51200 LicenseManagerSvc.dll
-a----        15-07-2024     15:46         149504 LicensingCSP.dll
-a----        20-01-2024     11:02         396288 licensingdiag.exe
-a----        15-07-2024     15:47         395776 LicensingDiagSpp.dll
-a----        17-11-2023     23:48         146816 LicensingUI.exe
-a----        15-07-2024     15:47         783856 LicensingWinRT.dll
-a----        07-12-2019     14:39          33280 licmgr10.dll
-a----        17-11-2023     23:48          31744 linkinfo.dll
-a----        15-07-2024     15:49         286208 ListSvc.dll
-a----        07-12-2019     14:38          49152 lltdapi.dll
-a----        07-12-2019     14:38           2560 lltdres.dll
-a----        17-11-2023     23:48         284672 lltdsvc.dll
-a----        07-12-2019     14:38          26112 lmhsvc.dll
-a----        07-12-2019     14:38         128512 loadperf.dll
-a----        15-07-2024     15:47         819432 locale.nls
-a----        15-07-2024     15:48         548352 localsec.dll
-a----        15-07-2024     15:46        1275904 localspl.dll
-a----        15-07-2024     15:46          19968 localui.dll
-a----        15-07-2024     15:48         409088 LocationApi.dll
-a----        15-07-2024     15:47        2033152 LocationFramework.dll
-a----        15-07-2024     15:47          83456 LocationFrameworkInternalPS.dll
-a----        15-07-2024     15:47          41440 LocationFrameworkPS.dll
-a----        15-07-2024     15:48          71168 LocationNotificationWindows.exe
-a----        15-07-2024     15:48         119296 LocationWinPalMisc.dll
-a----        07-12-2019     14:38          11264 Locator.exe
-a----        15-07-2024     15:47         458240 LockAppBroker.dll
-a----        15-07-2024     15:47          94040 LockAppHost.exe
-a----        15-07-2024     15:47         676864 LockController.dll
-a----        15-07-2024     15:47         457216 LockHostingFramework.dll
-a----        15-07-2024     15:46         173568 LockScreenContent.dll
-a----        15-07-2024     15:46          46592 LockScreenContentHost.dll
-a----        17-11-2023     23:47          49720 LockScreenContentServer.exe
-a----        15-07-2024     15:47         433152 LockScreenData.dll
-a----        07-12-2019     14:38          52224 lodctr.exe
-a----        17-11-2023     23:50         112640 logagent.exe
-a----        07-12-2019     14:39          83968 loghours.dll
-a----        17-11-2023     23:49         120320 logman.exe
-a----        15-07-2024     15:47         267560 logoncli.dll
-a----        15-07-2024     15:47         872448 LogonController.dll
-a----        07-12-2019     14:38          13824 LogonUI.exe
-a----        17-11-2023     23:47        1253888 lpasvc.dll
-a----        15-07-2024     15:47           3072 lpk.dll
-a----        17-11-2023     23:48          41984 lpkinstall.exe
-a----        15-07-2024     15:47         745472 lpksetup.exe
-a----        17-11-2023     23:48          10240 lpksetupproxyserv.dll
-a----        15-07-2024     15:47          72704 lpremove.exe
-a----        15-07-2024     15:47         340888 LsaIso.exe
-a----        15-07-2024     15:47        1672192 lsasrv.dll
-a----        15-07-2024     15:47          60640 lsass.exe
-a----        15-07-2024     15:47         846848 lsm.dll
-a----        17-11-2023     23:49          47616 lsmproxy.dll
-a----        17-11-2023     23:47          71144 luainstall.dll
-a----        07-12-2019     14:38          35840 luiapi.dll
-a----        07-12-2019     14:38         144998 lusrmgr.msc
-a----        07-12-2019     14:38           3072 lz32.dll
-a----        07-12-2019     14:38           9926 l_intl.nls
-a----        07-12-2019     14:38          52736 Magnification.dll
-a----        15-07-2024     15:47         650752 Magnify.exe
-a----        15-07-2024     15:47          75776 main.cpl
-a----        15-07-2024     15:47         117248 MaintenanceUI.dll
-a----        29-10-2023     08:36          86528 makecab.exe
-a----        07-12-2019     15:22         227328 manage-bde.exe
-a----        15-07-2024     15:46         233984 ManageCI.dll
-a----        15-07-2024     15:47         542208 MapConfiguration.dll
-a----        15-07-2024     15:47         230400 MapControlCore.dll
-a----        07-12-2019     14:38           2560 MapControlStringsRes.dll
-a----        15-07-2024     15:47        2632704 MapGeocoder.dll
-a----        15-07-2024     15:47         154112 mapi32.dll
-a----        15-07-2024     15:47         154112 mapistub.dll
-a----        15-07-2024     15:47        3182080 MapRouter.dll
-a----        15-07-2024     15:47         130048 MapsBtSvc.dll
-a----        07-12-2019     14:38          15360 MapsBtSvcProxy.dll
-a----        15-07-2024     15:47          98816 MapsCSP.dll
-a----        15-07-2024     15:47        1132544 MapsStore.dll
-a----        15-07-2024     15:47          54272 mapstoasttask.dll
-a----        15-07-2024     15:47          45568 mapsupdatetask.dll
-a----        15-07-2024     15:47         916480 MbaeApi.dll
-a----        15-07-2024     15:47        1201152 MbaeApiPublic.dll
-a----        07-12-2019     14:39         119296 MbaeParserTask.exe
-a----        07-12-2019     14:39          51712 MbaeXmlParser.dll
-a----        15-07-2024     15:48         808960 mblctr.exe
-a----        15-07-2024     15:47         746496 MBMediaManager.dll
-a----        15-07-2024     15:48        1178112 MBR2GPT.EXE
-a----        15-07-2024     15:47         686592 mbsmsapi.dll
-a----        15-07-2024     15:47          89600 mbussdapi.dll
-a----        07-12-2019     14:38          94208 mcbuilder.exe
-a----        15-07-2024     15:49         177664 MCCSEngineShared.dll
-a----        06-12-2019     22:05          31744 MCCSPal.dll
-a----        07-12-2019     14:39         103936 mciavi32.dll
-a----        07-12-2019     14:38          50176 mcicda.dll
-a----        07-12-2019     14:39          44032 mciqtz32.dll
-a----        07-12-2019     14:38          31232 mciseq.dll
-a----        07-12-2019     14:38          31744 mciwave.dll
-a----        17-11-2023     23:49          24576 McpManagementProxy.dll
-a----        15-07-2024     15:48         258048 McpManagementService.dll
-a----        15-07-2024     15:48        1091072 MCRecvSrc.dll
-a----        07-12-2019     14:38         110096 mcupdate_AuthenticAMD.dll
-a----        07-12-2019     14:38        2629648 mcupdate_GenuineIntel.dll
-a----        17-11-2023     23:50         454656 MDEServer.exe
-a----        15-07-2024     15:46         172544 MDMAgent.exe
-a----        15-07-2024     15:48         174592 MDMAppInstaller.exe
-a----        15-07-2024     15:46         182272 MdmCommon.dll
-a----        15-07-2024     15:47        2146304 MdmDiagnostics.dll
-a----        15-07-2024     15:47          52736 MdmDiagnosticsTool.exe
-a----        07-12-2019     14:39          79360 mdminst.dll
-a----        15-07-2024     15:47          81920 mdmlocalmanagement.dll
-a----        15-07-2024     15:47         181248 mdmmigrator.dll
-a----        15-07-2024     15:47          51200 mdmpostprocessevaluator.dll
-a----        15-07-2024     15:47         425472 mdmregistration.dll
-a----        07-12-2019     14:39          87040 MdRes.exe
-a----        07-12-2019     14:39          92672 MdSched.exe
-a----        15-07-2024     15:47         134656 MediaFoundation.DefaultPerceptionProvider.dll
-a----        07-12-2019     14:38           1284 MediaSystemToastIcon.contrast-white.png
-a----        07-12-2019     14:38            854 MediaSystemToastIcon.png
-a----        07-12-2019     14:38         110036 MediumRoom.bin
-a----        22-03-2024     13:02          33792 MemoryDiagnostic.dll
-a----        15-07-2024     15:47        1077760 MessagingDataModel2.dll
-a----        15-07-2024     15:46          91648 MessagingService.dll
-a----        15-07-2024     15:49         532704 mf.dll
-a----        17-11-2023     23:48          64512 mf3216.dll
-a----        07-12-2019     15:22         142168 mfAACEnc.dll
-a----        15-07-2024     15:49        1957624 mfasfsrcsnk.dll
-a----        17-11-2023     23:50         155648 mfaudiocnv.dll
-a----        19-01-2024     20:38        5631056 mfc140.dll
-a----        19-01-2024     20:38          51280 mfc140chs.dll
-a----        19-01-2024     20:38          51280 mfc140cht.dll
-a----        19-01-2024     20:38          79976 mfc140deu.dll
-a----        19-01-2024     20:38          70224 mfc140enu.dll
-a----        19-01-2024     20:38          78928 mfc140esn.dll
-a----        19-01-2024     20:38          79952 mfc140fra.dll
-a----        19-01-2024     20:38          77928 mfc140ita.dll
-a----        19-01-2024     20:38          58960 mfc140jpn.dll
-a----        19-01-2024     20:38          58448 mfc140kor.dll
-a----        19-01-2024     20:38          75880 mfc140rus.dll
-a----        19-01-2024     20:38        5665360 mfc140u.dll
-a----        29-10-2023     08:36        1456640 mfc42.dll
-a----        29-10-2023     08:36        1468928 mfc42u.dll
-a----        15-07-2024     15:49         678272 MFCaptureEngine.dll
-a----        19-01-2024     20:38          96880 mfcm140.dll
-a----        19-01-2024     20:38          96848 mfcm140u.dll
-a----        15-07-2024     15:49        4798976 mfcore.dll
-a----        07-12-2019     14:38          36864 mfcsubs.dll
-a----        17-11-2023     23:50         963416 mfds.dll
-a----        07-12-2019     15:22         148992 mfdvdec.dll
-a----        07-12-2019     15:22          70656 mferror.dll
-a----        07-12-2019     15:22          53248 mfh263enc.dll
-a----        17-11-2023     23:50         581120 mfh264enc.dll
-a----        07-12-2019     14:39         292864 mfksproxy.dll
-a----        15-07-2024     15:49        4310016 MFMediaEngine.dll
-a----        17-11-2023     23:50         100864 mfmjpegdec.dll
-a----        15-07-2024     15:49        1252864 mfmkvsrcsnk.dll
-a----        15-07-2024     15:49        2120296 mfmp4srcsnk.dll
-a----        15-07-2024     15:49        1354384 mfmpeg2srcsnk.dll
-a----        15-07-2024     15:49        1227352 mfnetcore.dll
-a----        15-07-2024     15:49        1817608 mfnetsrc.dll
-a----        07-12-2019     15:22        1233600 mfperfhelper.dll
-a----        15-07-2024     15:49        1815128 mfplat.dll
-a----        15-07-2024     15:49         585744 MFPlay.dll
-a----        07-12-2019     15:22          47504 mfpmp.exe
-a----        17-11-2023     23:50         268168 mfps.dll
-a----        17-11-2023     23:50        1088808 mfreadwrite.dll
-a----        15-07-2024     15:48         415288 mfsensorgroup.dll
-a----        15-07-2024     15:49        2206528 mfsrcsnk.dll
-a----        15-07-2024     15:49        1533616 mfsvr.dll
-a----        07-12-2019     15:22         352768 mftranscode.dll
-a----        17-11-2023     23:50          99816 mfvdsp.dll
-a----        07-12-2019     15:22          46080 mfvfw.dll
-a----        07-12-2019     15:22         466944 MFWMAAEC.DLL
-a----        02-08-2021     19:21       26737472 mfxplugin64_hw.dll
-a----        07-12-2019     14:38          24576 mgmtapi.dll
-a----        15-07-2024     15:49         119296 mgmtrefreshcredprov.dll
-a----        17-11-2023     23:48         127488 mi.dll
-a----        07-12-2019     14:38          91136 mibincodec.dll
-a----        07-12-2019     14:38         212992 Microsoft-Windows-AppModelExecEvents.dll
-a----        07-12-2019     14:39          21304 microsoft-windows-battery-events.dll
-a----        07-12-2019     14:39          15672 microsoft-windows-hal-events.dll
-a----        15-07-2024     15:46         188416 Microsoft-Windows-Internal-Shell-NearShareExperience.dll
-a----        07-12-2019     14:39          54800 microsoft-windows-kernel-pnp-events.dll
-a----        07-12-2019     14:39         323384 microsoft-windows-kernel-power-events.dll
-a----        07-12-2019     14:39         175112 microsoft-windows-kernel-processor-power-events.dll
-a----        07-12-2019     14:38         113664 Microsoft-Windows-MapControls.dll
-a----        07-12-2019     14:38           8192 Microsoft-Windows-MosHost.dll
-a----        07-12-2019     14:39          82232 microsoft-windows-pdc.dll
-a----        07-12-2019     14:38          10240 microsoft-windows-power-cad-events.dll
-a----        07-12-2019     14:39           4096 microsoft-windows-processor-aggregator-events.dll
-a----        07-12-2019     14:39          17424 microsoft-windows-sleepstudy-events.dll
-a----        07-12-2019     14:38           6144 microsoft-windows-storage-tiering-events.dll
-a----        15-07-2024     15:47         501640 microsoft-windows-system-events.dll
-a----        07-12-2019     14:38           2560 Microsoft-WindowsPhone-SEManagementProvider.dll
-a----        15-07-2024     15:47         297984 Microsoft.Bluetooth.Proxy.dll
-a----        15-07-2024     15:47        3769856 Microsoft.Bluetooth.Service.dll
-a----        15-07-2024     15:46         501248 Microsoft.Bluetooth.UserService.dll
-a----        15-07-2024     15:48        1191936 Microsoft.Graphics.Display.DisplayEnhancementService.dll
-a----        15-07-2024     15:46         110592 Microsoft.LocalUserImageProvider.dll
-a----        17-11-2023     23:50          18432 Microsoft.Management.Infrastructure.Native.Unmanaged.dll
-a----        15-07-2024     15:46         741376 MicrosoftAccount.TokenProvider.Core.dll
-a----        15-07-2024     15:46         281600 MicrosoftAccountCloudAP.dll
-a----        15-07-2024     15:46         441344 MicrosoftAccountExtension.dll
-a----        15-07-2024     15:46         296448 MicrosoftAccountTokenProvider.dll
-a----        15-07-2024     15:46         555008 MicrosoftAccountWAMExtension.dll
-a----        15-07-2024     15:46          97280 MicrosoftEdgeBCHost.exe
-a----        15-07-2024     15:47          97280 MicrosoftEdgeCP.exe
-a----        15-07-2024     15:46          97280 MicrosoftEdgeDevTools.exe
-a----        15-07-2024     15:47          58880 MicrosoftEdgeSH.exe
-a----        17-11-2023     23:47          27136 midimap.dll
-a----        17-11-2023     23:49         146288 migisol.dll
-a----        07-12-2019     14:39         183808 miguiresource.dll
-a----        07-12-2019     14:39          40448 mimefilt.dll
-a----        07-12-2019     14:38         158208 mimofcodec.dll
-a----        07-12-2019     14:38          17408 MinstoreEvents.dll
-a----        17-11-2023     23:48          37376 MiracastInputMgr.dll
-a----        15-07-2024     15:46        1263104 MiracastReceiver.dll
-a----        15-07-2024     15:48          91136 MiracastReceiverExt.dll
-a----        07-12-2019     14:39          38912 MirrorDrvCompat.dll
-a----        15-07-2024     15:48        3171200 mispace.dll
-a----        15-07-2024     15:46         512512 MitigationClient.dll
-a----        15-07-2024     15:47          86528 MitigationConfiguration.dll
-a----        17-11-2023     23:48         245248 miutils.dll
-a----        15-07-2024     15:49         422400 MixedReality.Broker.dll
-a----        15-07-2024     15:49         567296 MixedRealityCapture.Pipeline.dll
-a----        15-07-2024     15:49         135944 MixedRealityRuntime.dll
-a----        07-12-2019     14:40            112 MixedRealityRuntime.json
-a----        07-12-2019     14:39         673088 mlang.dat
-a----        17-11-2023     23:48         249856 mlang.dll
-a----        15-07-2024     15:48        1954304 mmc.exe
-a----        07-12-2019     14:42           3103 mmc.exe.config
-a----        17-11-2023     23:49         186368 mmcbase.dll
-a----        17-11-2023     23:49        2415104 mmcndmgr.dll
-a----        17-11-2023     23:49         136192 mmcshext.dll
-a----        15-07-2024     15:46         530616 MMDevAPI.dll
-a----        15-07-2024     15:47        1700864 mmgaclient.dll
-a----        07-12-2019     14:38         155136 mmgaproxystub.dll
-a----        15-07-2024     15:47        1288704 mmgaserver.exe
-a----        07-12-2019     14:38           3584 mmres.dll
-a----        15-07-2024     15:47         544256 mmsys.cpl
-a----        17-11-2023     23:48          21504 mobilenetworking.dll
-a----        15-07-2024     15:48          99328 mobsync.exe
-a----        17-11-2023     23:49          33280 mode.com
-a----        07-12-2019     14:39         192512 modemui.dll
-a----        15-07-2024     15:46         488448 modernexecserver.dll
-a----        07-12-2019     14:39          29696 more.com
-a----        07-12-2019     14:39           2560 moricons.dll
-a----        15-07-2024     15:47          94720 moshost.dll
-a----        17-11-2023     23:48          93696 MosHostClient.dll
-a----        15-07-2024     15:47         235496 moshostcore.dll
-a----        15-07-2024     15:47          88576 MosStorage.dll
-a----        07-12-2019     14:39          18944 mountvol.exe
-a----        07-12-2019     14:38           1386 MouseSystemToastIcon.contrast-white.png
-a----        07-12-2019     14:38           1087 MouseSystemToastIcon.png
-a----        15-07-2024     15:47        1789952 MoUsoCoreWorker.exe
-a----        07-12-2019     15:22         105048 MP3DMOD.DLL
-a----        17-11-2023     23:50         241376 MP43DECD.DLL
-a----        17-11-2023     23:50         363144 MP4SDECD.DLL
-a----        07-12-2019     14:39         103936 Mpeg2Data.ax
-a----        07-12-2019     14:39         235520 mpeval.dll
-a----        17-11-2023     23:49         266240 mpg2splt.ax
-a----        17-11-2023     23:50         241888 MPG4DECD.DLL
-a----        07-12-2019     14:38          19968 mpnotify.exe
-a----        17-11-2023     23:48         110688 mpr.dll
-a----        15-07-2024     15:47         532992 mprapi.dll
-a----        15-07-2024     15:47         920064 mprddm.dll
-a----        15-07-2024     15:47         552448 mprdim.dll
-a----        07-12-2019     14:39          13824 mprext.dll
-a----        17-11-2023     23:49         115200 mprmsg.dll
------        18-01-2024     23:11         918944 MpSigStub.exe
-a----        15-07-2024     15:47        1174016 MPSSVC.dll
-a----        07-12-2019     14:39         495104 mpunits.dll
-a----        07-12-2019     14:39          17408 MRINFO.EXE
-a----        15-07-2024     15:47        1016056 MrmCoreR.dll
-a----        15-07-2024     15:47         328520 MrmDeploy.dll
-a----        15-07-2024     15:47         820224 MrmIndexer.dll
-a----        15-07-2024     15:33      194135240 MRT.exe
-a----        07-12-2019     14:38          31904 mrt100.dll
-a----        07-12-2019     14:38          33440 mrt_map.dll
-a----        15-07-2024     15:47          58368 ms3dthumbnailprovider.dll
-a----        17-11-2023     23:49         170496 msaatext.dll
-a----        07-12-2019     15:22         243200 MSAC3ENC.DLL
-a----        07-12-2019     14:38         112080 msacm32.dll
-a----        17-11-2023     23:47          30208 msacm32.drv
-a----        17-11-2023     23:47          36720 msadp32.acm
-a----        07-12-2019     14:38           3072 msafd.dll
-a----        15-07-2024     15:46        3001856 MSAJApi.dll
-a----        17-11-2023     23:50          58368 MSAlacDecoder.dll
-a----        17-11-2023     23:50          76800 MSAlacEncoder.dll
-a----        07-12-2019     15:22         140800 MSAMRNBDecoder.dll
-a----        07-12-2019     15:22         217088 MSAMRNBEncoder.dll
-a----        07-12-2019     15:22          38400 MSAMRNBSink.dll
-a----        07-12-2019     15:22         101376 MSAMRNBSource.dll
-a----        20-01-2024     11:02          55296 MSAProfileNotificationHandler.dll
-a----        17-11-2023     23:48          65248 msasn1.dll
-a----        15-07-2024     15:49         424320 MSAudDecMFT.dll
-a----        17-11-2023     23:48         155648 msaudite.dll
-a----        20-01-2024     11:02          24064 msauserext.dll
-a----        07-12-2019     14:39         315392 mscandui.dll
-a----        07-12-2019     14:38          11776 mscat32.dll
-a----        07-12-2019     14:38          83968 MSchedExe.exe
-a----        17-11-2023     23:53         232448 msclmd.dll
-a----        15-07-2024     15:47         710184 mscms.dll
-a----        17-11-2023     23:49         197632 msconfig.exe
-a----        07-12-2019     14:40         383488 mscoree.dll
-a----        07-12-2019     14:40          19968 mscorier.dll
-a----        07-12-2019     14:40          76360 mscories.dll
-a----        15-07-2024     15:47        1125064 msctf.dll
-a----        07-12-2019     14:39          10752 msctfime.ime
-a----        15-07-2024     15:47          94208 MsCtfMonitor.dll
-a----        17-11-2023     23:49         219136 msctfp.dll
-a----        07-12-2019     14:39         126976 msctfui.dll
-a----        15-07-2024     15:47         799744 msctfuimanager.dll
-a----        07-12-2019     14:39         160256 msdadiag.dll
-a----        07-12-2019     14:38         137728 msdart.dll
-a----        07-12-2019     14:39           5120 msdatsrc.tlb
-a----        17-11-2023     23:48         559072 msdelta.dll
-a----        07-12-2019     14:38          34600 msdmo.dll
-a----        07-12-2019     14:38         570368 msdrm.dll
-a----        15-07-2024     15:48         498176 msdt.exe
-a----        15-07-2024     15:48         182784 msdtc.exe
-a----        15-07-2024     15:48         408064 msdtckrm.dll
-a----        15-07-2024     15:48         162816 msdtclog.dll
-a----        15-07-2024     15:48         922624 msdtcprx.dll
-a----        15-07-2024     15:48          15872 msdtcspoffln.dll
-a----        15-07-2024     15:48        1658368 msdtctm.dll
-a----        15-07-2024     15:48         372224 msdtcuiu.dll
-a----        07-12-2019     14:38          22528 msdtcVSp1res.dll
-a----        07-12-2019     14:39          79872 MSDvbNP.ax
-a----        17-11-2023     23:50           7168 msdxm.ocx
-a----        07-12-2019     01:25          44032 msdxm.tlb
-a----        15-07-2024     15:48         791552 msfeeds.dll
-a----        15-07-2024     15:48          76800 msfeedsbs.dll
-a----        07-12-2019     14:39          14848 msfeedssync.exe
-a----        15-07-2024     15:49         464896 MSFlacDecoder.dll
-a----        15-07-2024     15:49         294400 MSFlacEncoder.dll
-a----        15-07-2024     15:46        3423744 msftedit.dll
-a----        15-07-2024     15:47          57344 MsftOemDllIgneous.dll
-a----        17-11-2023     23:47          27008 msg711.acm
-a----        17-11-2023     23:47          44096 msgsm32.acm
-a----        17-11-2023     23:50          36864 MSHEIF.dll
-a----        15-07-2024     15:48          43520 mshta.exe
-a----        15-07-2024     15:48       23450624 mshtml.dll
-a----        15-07-2024     15:48        2755584 mshtml.tlb
-a----        07-12-2019     14:39          83968 MshtmlDac.dll
-a----        17-11-2023     23:49         102912 mshtmled.dll
-a----        07-12-2019     14:39          49152 mshtmler.dll
-a----        15-07-2024     15:48        3339776 msi.dll
-a----        07-12-2019     14:39          46080 MsiCofire.dll
-a----        17-11-2023     23:48          15872 msidcrl40.dll
-a----        07-12-2019     14:38          67072 msident.dll
-a----        07-12-2019     14:38          11776 msidle.dll
-a----        07-12-2019     14:38           5120 msidntld.dll
-a----        15-07-2024     15:46         280064 msieftp.dll
-a----        15-07-2024     15:48          69632 msiexec.exe
-a----        07-12-2019     14:39         412672 msihnd.dll
-a----        07-12-2019     14:39          22528 msiltcfg.dll
-a----        17-11-2023     23:48           8192 msimg32.dll
-a----        15-07-2024     15:48          26112 msimsg.dll
-a----        07-12-2019     14:39          51712 msimtf.dll
-a----        17-11-2023     23:49         386048 msinfo32.exe
-a----        15-07-2024     15:48          70656 msisip.dll
-a----        15-07-2024     15:47         333824 msIso.dll
-a----        07-12-2019     14:39          12288 msiwer.dll
-a----        15-07-2024     15:46         194560 mskeyprotcli.dll
-a----        17-11-2023     23:48          66560 mskeyprotect.dll
-a----        29-10-2023     08:36         215552 msls31.dll
-a----        15-07-2024     15:49        1069352 msmpeg2adec.dll
-a----        15-07-2024     15:49         944128 MSMPEG2ENC.DLL
-a----        15-07-2024     15:49        2521144 msmpeg2vdec.dll
-a----        07-12-2019     14:39         260096 MSNP.ax
-a----        17-11-2023     23:48          63488 msobjs.dll
-a----        17-11-2023     23:49         118784 msoert2.dll
-a----        17-11-2023     23:50         166912 MSOpusDecoder.dll
-a----        15-07-2024     15:49         938496 mspaint.exe
-a----        17-11-2023     23:48          57304 mspatcha.dll
-a----        29-10-2023     08:36          84480 mspatchc.dll
-a----        17-11-2023     23:50        1669632 MSPhotography.dll
-a----        07-12-2019     14:39          60416 msports.dll
-a----        07-12-2019     14:38           2560 msprivs.dll
-a----        17-11-2023     23:50         592896 msra.exe
-a----        17-11-2023     23:50         137216 msrahc.dll
-a----        17-11-2023     23:50           7680 MsraLegacy.tlb
-a----        07-12-2019     14:38          12288 msrating.dll
-a----        17-11-2023     23:50          36864 MSRAWImage.dll
-a----        17-11-2023     23:49         185856 msrdc.dll
-a----        17-11-2023     23:49          63488 MsRdpWebAccess.dll
-a----        07-12-2019     14:39          18432 msrle32.dll
-a----        15-07-2024     15:47          66048 msscntrs.dll
-a----        07-12-2019     14:38          80896 mssign32.dll
-a----        07-12-2019     14:38          10240 mssip32.dll
-a----        15-07-2024     15:47         131072 mssitlb.dll
-a----        15-07-2024     15:49         938496 MsSpellCheckingFacility.dll
-a----        17-11-2023     23:50          84480 MsSpellCheckingHost.exe
-a----        15-07-2024     15:47         214528 mssph.dll
-a----        15-07-2024     15:47         145920 mssprxy.dll
-a----        15-07-2024     15:47        2980352 mssrch.dll
-a----        15-07-2024     15:47         381952 mssvp.dll
-a----        07-12-2019     14:39         147456 mstask.dll
-a----        15-07-2024     15:48         486912 msTextPrediction.dll
-a----        15-07-2024     15:49        1297408 mstsc.exe
-a----        15-07-2024     15:48        8380416 mstscax.dll
-a----        17-11-2023     23:49         262144 msutb.dll
-a----        15-07-2024     15:47         545152 msv1_0.dll
-a----        07-12-2019     14:38          83968 msvcirt.dll
-a----        02-02-2002     08:32         608080 msvcp100.dll
-a----        17-11-2023     23:47         561568 msvcp110_win.dll
-a----        07-12-2019     14:40         690008 msvcp120_clr0400.dll
-a----        01-02-2002     19:02         573008 msvcp140.dll
-a----        01-02-2002     19:02          35920 msvcp140_1.dll
-a----        01-02-2002     19:02         268392 msvcp140_2.dll
-a----        01-02-2002     19:02          50280 msvcp140_atomic_wait.dll
-a----        25-06-2022     03:01         571280 msvcp140_clr0400.dll
-a----        01-02-2002     19:02          31856 msvcp140_codecvt_ids.dll
-a----        07-12-2019     14:38         611840 msvcp60.dll
-a----        17-11-2023     23:48         635952 msvcp_win.dll
-a----        02-02-2002     08:32         829264 msvcr100.dll
-a----        25-06-2022     07:46          12688 msvcr100_clr0400.dll
-a----        07-12-2019     14:40         993632 msvcr120_clr0400.dll
-a----        17-11-2023     23:48         638552 msvcrt.dll
-a----        07-12-2019     14:39         152064 msvfw32.dll
-a----        07-12-2019     14:39          39936 msvidc32.dll
-a----        17-11-2023     23:49        3452416 MSVidCtl.dll
-a----        17-11-2023     23:50         724784 MSVideoDSP.dll
-a----        17-11-2023     23:50          44456 MSVP9DEC.dll
-a----        15-07-2024     15:49        1440016 msvproc.dll
-a----        17-11-2023     23:50          44472 MSVPXENC.dll
-a----        17-11-2023     23:48         260464 MSWB7.dll
-a----        17-11-2023     23:50          35328 MSWebp.dll
-a----        17-11-2023     23:50         428544 mswmdm.dll
-a----        17-11-2023     23:48         419584 mswsock.dll
-a----        15-07-2024     15:47        1696256 msxml3.dll
-a----        17-11-2023     23:48           2560 msxml3r.dll
-a----        15-07-2024     15:46        2474760 msxml6.dll
-a----        17-11-2023     23:48           2560 msxml6r.dll
-a----        07-12-2019     14:39          27648 msyuv.dll
-a----        15-07-2024     15:47         221184 MtcModel.dll
-a----        15-07-2024     15:47         284144 MTF.dll
-a----        15-07-2024     15:46         103936 MTFAppServiceDS.dll
-a----        15-07-2024     15:46         319488 MtfDecoder.dll
-a----        15-07-2024     15:46         176640 MTFFuzzyDS.dll
-a----        15-07-2024     15:47         282112 MTFServer.dll
-a----        15-07-2024     15:46         115200 MTFSpellcheckDS.dll
-a----        07-12-2019     14:38         137216 mtstocom.exe
-a----        15-07-2024     15:48         474624 mtxclu.dll
-a----        07-12-2019     14:38          31744 mtxdm.dll
-a----        07-12-2019     14:38           9728 mtxex.dll
-a----        15-07-2024     15:48         180224 mtxoci.dll
-a----        07-12-2019     14:38          18944 muifontsetup.dll
-a----        17-11-2023     23:48          16896 MUILanguageCleanup.dll
-a----        15-07-2024     15:47         107008 MuiUnattend.exe
-a----        07-12-2019     14:39          54784 MultiDigiMon.exe
-a----        15-07-2024     15:47         186880 musdialoghandlers.dll
-a----        15-07-2024     15:47         695296 MusNotification.exe
-a----        15-07-2024     15:47         632320 MusNotificationUx.exe
-a----        15-07-2024     15:47         648872 MusNotifyIcon.exe
-a----        15-07-2024     15:47        1182720 MusUpdateHandlers.dll
-a----        17-11-2023     23:49         131584 mycomput.dll
-a----        15-07-2024     15:47          50688 mydocs.dll
-a----        15-07-2024     15:48         155136 Mystify.scr
-a----        17-11-2023     23:49          50688 NAPCRYPT.DLL
-a----        17-11-2023     23:48          70144 NapiNSP.dll
-a----        15-07-2024     15:47         534016 Narrator.exe
-a----        07-12-2019     14:38          30811 NarratorControlTemplates.xml
-a----        15-07-2024     15:46         454656 NaturalAuth.dll
-a----        07-12-2019     14:38          22528 NaturalAuthClient.dll
-a----        15-07-2024     15:46        1071104 NaturalLanguage6.dll
-a----        15-07-2024     15:47          41472 navshutdown.dll
-a----        07-12-2019     14:39          22016 nbtstat.exe
-a----        07-12-2019     14:38          25600 NcaApi.dll
-a----        07-12-2019     14:38         171520 NcaSvc.dll
-a----        17-11-2023     23:48         382464 ncbservice.dll
-a----        15-07-2024     15:49          92672 NcdAutoSetup.dll
-a----        07-12-2019     14:39          26112 NcdProp.dll
-a----        15-07-2024     15:47          47104 nci.dll
-a----        15-07-2024     15:46          75264 ncobjapi.dll
-a----        17-11-2023     23:49         102912 ncpa.cpl
-a----        15-07-2024     15:47         160168 ncrypt.dll
-a----        15-07-2024     15:47         354816 ncryptprov.dll
-a----        17-11-2023     23:48         139608 ncryptsslp.dll
-a----        15-07-2024     15:47         528896 ncsi.dll
-a----        07-12-2019     14:39          30720 ncuprov.dll
-a----        29-10-2023     08:36          69632 ndadmin.exe
-a----        07-12-2019     14:39          12288 nddeapi.dll
-a----        17-11-2023     23:49         280064 ndfapi.dll
-a----        17-11-2023     23:49          45568 ndfetw.dll
-a----        07-12-2019     14:39            565 NdfEventView.xml
-a----        17-11-2023     23:49         119296 ndfhcdiscovery.dll
-a----        17-11-2023     23:49         100352 ndishc.dll
-a----        07-12-2019     14:39          32272 NDKPing.exe
-a----        07-12-2019     14:39          32768 ndproxystub.dll
-a----        15-07-2024     15:48         132608 nduprov.dll
-a----        15-07-2024     15:46         147968 negoexts.dll
-a----        07-12-2019     14:39          59904 net.exe
-a----        17-11-2023     23:49         183808 net1.exe
-a----        17-11-2023     23:48          89024 netapi32.dll
-a----        07-12-2019     14:39          18944 netbios.dll
-a----        17-11-2023     23:49          27136 netbtugc.exe
-a----        07-12-2019     14:39          69632 NetCellcoreCellManagerProviderResources.dll
-a----        15-07-2024     15:48         248320 netcenter.dll
-a----        07-12-2019     14:38          37376 netcfg.exe
-a----        15-07-2024     15:47          76288 NetCfgNotifyObjectHost.exe
-a----        15-07-2024     15:47         105968 netcfgx.dll
-a----        15-07-2024     15:48         475648 netcorehc.dll
-a----        15-07-2024     15:48         325632 netdiagfx.dll
-a----        15-07-2024     15:47         113664 NetDriverInstall.dll
-a----        07-12-2019     14:38          20480 netevent.dll
-a----        07-12-2019     14:39          35328 NetEvtFwdr.exe
-a----        07-12-2019     14:40         107520 netfxperf.dll
-a----        07-12-2019     14:39           2560 neth.dll
-a----        07-12-2019     14:39          10752 NetHost.exe
-a----        15-07-2024     15:47         203264 netid.dll
-a----        17-11-2023     23:49         196096 netiohlp.dll
-a----        17-11-2023     23:49          31744 netiougc.exe
-a----        23-02-2024     23:41         192512 netjoin.dll
-a----        15-07-2024     15:47         910848 netlogon.dll
-a----        17-11-2023     23:47         288768 netman.dll
-a----        15-07-2024     15:49         223712 NetMgmtIF.dll
-a----        15-07-2024     15:47           2560 netmsg.dll
-a----        15-07-2024     15:47         326144 netplwiz.dll
-a----        15-07-2024     15:47          40960 Netplwiz.exe
-a----        15-07-2024     15:47         231936 netprofm.dll
-a----        15-07-2024     15:47        1005568 netprofmsvc.dll
-a----        17-11-2023     23:49          68096 netprovfw.dll
-a----        17-11-2023     23:49          71680 netprovisionsp.dll
-a----        15-07-2024     15:47         147336 NetSetupApi.dll
-a----        15-07-2024     15:47         810352 NetSetupEngine.dll
-a----        15-07-2024     15:47         470016 NetSetupShim.dll
-a----        15-07-2024     15:47         329216 NetSetupSvc.dll
-a----        07-12-2019     14:39          96768 netsh.exe
-a----        15-07-2024     15:47         568832 netshell.dll
-a----        07-12-2019     14:39          39936 NETSTAT.EXE
-a----        15-07-2024     15:48         402944 nettrace.dll
-a----        07-12-2019     14:39          21656 NetTrace.PLA.Diagnostics.xml
-a----        29-10-2023     08:37          73216 nettraceex.dll
-a----        17-11-2023     23:48          43000 netutils.dll
-a----        15-07-2024     15:47         347000 NetworkBindingEngineMigPlugin.dll
-a----        17-11-2023     23:49         604672 NetworkCollectionAgent.dll
-a----        15-07-2024     15:47         205312 NetworkDesktopSettings.dll
-a----        15-07-2024     15:47          80896 networkexplorer.dll
-a----        15-07-2024     15:49         128000 networkhelper.dll
-a----        15-07-2024     15:46         170496 NetworkIcon.dll
-a----        07-12-2019     14:38          56320 networkitemfactory.dll
-a----        15-07-2024     15:47        3143168 NetworkMobileSettings.dll
-a----        07-12-2019     14:38          29184 NetworkProxyCsp.dll
-a----        15-07-2024     15:47         110080 NetworkQoSPolicyCSP.dll
-a----        15-07-2024     15:47         128000 NetworkStatus.dll
-a----        15-07-2024     15:47         427520 NetworkUXBroker.dll
-a----        15-07-2024     15:47         312832 newdev.dll
-a----        29-10-2023     08:36          72192 newdev.exe
-a----        15-07-2024     15:46         107008 NFCProvisioningPlugin.dll
-a----        17-11-2023     23:48          55296 NfcRadioMedia.dll
-a----        15-07-2024     15:46         680960 ngccredprov.dll
-a----        15-07-2024     15:46         567808 NgcCtnr.dll
-a----        15-07-2024     15:47         460800 NgcCtnrGidsHandler.dll
-a----        15-07-2024     15:46         790528 NgcCtnrSvc.dll
-a----        15-07-2024     15:48         475856 NgcIso.exe
-a----        15-07-2024     15:48         695296 NgcIsoCtnr.dll
-a----        15-07-2024     15:46         205824 ngckeyenum.dll
-a----        15-07-2024     15:46         133632 ngcksp.dll
-a----        15-07-2024     15:47          74752 ngclocal.dll
-a----        15-07-2024     15:46         273920 ngcpopkeysrv.dll
-a----        15-07-2024     15:46         172544 NgcProCsp.dll
-a----        15-07-2024     15:46         284160 ngcrecovery.dll
-a----        15-07-2024     15:46         948224 ngcsvc.dll
-a----        15-07-2024     15:47         279040 ngctasks.dll
-a----        09-08-2024     15:40              0 nginx-deployment.yaml
-a----        15-07-2024     15:47         409088 ninput.dll
-a----        22-03-2024     13:02          97280 nlaapi.dll
-a----        17-11-2023     23:49          96256 nlahc.dll
-a----        22-03-2024     13:02         388608 nlasvc.dll
-a----        15-07-2024     15:47         195072 nlhtml.dll
-a----        17-11-2023     23:49         176128 nlmgp.dll
-a----        15-07-2024     15:47          33792 nlmproxy.dll
-a----        15-07-2024     15:47          20480 nlmsprep.dll
-a----        15-07-2024     15:47          91520 nlsbres.dll
-a----        07-12-2019     14:39        1579008 NlsData0000.dll
-a----        06-12-2019     21:56        6361600 NlsData0009.dll
-a----        07-12-2019     14:38          10752 Nlsdl.dll
-a----        06-12-2019     22:06        2629120 NlsLexicons0009.dll
-a----        17-11-2023     23:49         541184 nltest.exe
-a----        15-07-2024     15:47         259584 NmaDirect.dll
-a----        15-07-2024     15:49         143856 nmbind.exe
-a----        15-07-2024     15:49         152448 nmscrub.exe
-a----        07-12-2019     14:42            741 NOISE.DAT
-a----        17-11-2023     23:48           6144 normaliz.dll
-a----        07-12-2019     14:38          81870 normidna.nls
-a----        07-12-2019     14:38          57136 normnfc.nls
-a----        07-12-2019     14:38          50442 normnfd.nls
-a----        07-12-2019     14:38          79348 normnfkc.nls
-a----        07-12-2019     14:38          73114 normnfkd.nls
-a----        15-07-2024     15:49         200704 notepad.exe
-a----        15-07-2024     15:47        1229824 NotificationController.dll
-a----        15-07-2024     15:47         391680 NotificationControllerPS.dll
-a----        15-07-2024     15:47          46080 notificationplatformcomponent.dll
-a----        15-07-2024     15:47          49152 npmproxy.dll
-a----        15-07-2024     15:47         202240 NPSM.dll
-a----        15-07-2024     15:47         214016 NPSMDesktopProvider.dll
-a----        07-12-2019     14:38          19456 nrpsrv.dll
-a----        17-11-2023     23:49          52224 nshhttp.dll
-a----        17-11-2023     23:48         382464 nshipsec.dll
-a----        17-11-2023     23:49         789504 nshwfp.dll
-a----        17-11-2023     23:48          25976 nsi.dll
-a----        17-11-2023     23:48          34304 nsisvc.dll
-a----        07-12-2019     14:38          89600 nslookup.exe
-a----        17-11-2023     23:48         242328 ntasn1.dll
-a----        15-07-2024     15:47        2029080 ntdll.dll
-a----        17-11-2023     23:48         154112 ntdsapi.dll
-a----        15-07-2024     15:47         109056 ntlanman.dll
-a----        07-12-2019     14:39          20480 ntlanui2.dll
-a----        15-07-2024     15:47          70456 NtlmShared.dll
-a----        17-11-2023     23:48         192856 ntmarta.dll
-a----        15-07-2024     15:47       10872192 ntoskrnl.exe
-a----        15-07-2024     15:47         379904 ntprint.dll
-a----        17-11-2023     23:49          64000 ntprint.exe
-a----        15-07-2024     15:47         489472 ntshrui.dll
-a----        17-11-2023     23:48          19456 ntvdm64.dll
-a----        15-07-2024     15:49          42976 NvAgent.dll
-a----        15-07-2024     15:49         292728 nvspinfo.exe
-a----        15-07-2024     15:48         705024 objsel.dll
-a----        07-12-2019     14:39         153088 occache.dll
-a----        15-07-2024     15:47         202240 ocsetapi.dll
-a----        15-07-2024     15:48         757760 odbc32.dll
-a----        07-12-2019     14:39          74240 odbcad32.exe
-a----        07-12-2019     14:39          48128 odbcbcp.dll
-a----        17-11-2023     23:49          30720 odbcconf.dll
-a----        07-12-2019     14:39          27136 odbcconf.exe
-a----        07-12-2019     14:39            263 odbcconf.rsp
-a----        07-12-2019     14:39         134656 odbccp32.dll
-a----        07-12-2019     14:39          90112 odbccr32.dll
-a----        07-12-2019     14:39          90624 odbccu32.dll
-a----        07-12-2019     14:39         225280 odbcint.dll
-a----        07-12-2019     14:39         168960 odbctrac.dll
-a----        20-01-2024     11:04          23040 OEMDefaultAssociations.dll
-a----        13-03-2021     08:58          20611 OEMDefaultAssociations.xml
-a----        20-01-2024     11:02         134512 oemlicense.dll
-a----        17-11-2023     23:47          79872 ofdeploy.exe
-a----        07-12-2019     14:39         276480 offfilt.dll
-a----        17-11-2023     23:47         123392 officecsp.dll
-a----        15-07-2024     15:47         136168 offlinelsa.dll
-a----        15-07-2024     15:47         279008 offlinesam.dll
-a----        15-07-2024     15:48          90112 offreg.dll
-a----        07-12-2019     14:38          45568 oflc-nz.rs
-a----        07-12-2019     14:38            423 OkDone_80.contrast-black.png
-a----        07-12-2019     14:38            438 OkDone_80.contrast-white.png
-a----        07-12-2019     14:38            423 OkDone_80.png
-a----        15-07-2024     15:47        1217432 ole32.dll
-a----        17-11-2023     23:49         403968 oleacc.dll
-a----        17-11-2023     23:49          13312 oleacchooks.dll
-a----        07-12-2019     14:39           4608 oleaccrc.dll
-a----        17-11-2023     23:48         833136 oleaut32.dll
-a----        15-07-2024     15:47         210432 oledlg.dll
-a----        15-07-2024     15:46         152064 oleprn.dll
-a----        15-07-2024     15:46         230912 OmaDmAgent.dll
-a----        15-07-2024     15:47         225240 omadmapi.dll
-a----        15-07-2024     15:47         477184 omadmclient.exe
-a----        15-07-2024     15:47         121856 omadmprc.exe
-a----        17-11-2023     23:48          45568 OnDemandBrokerClient.dll
-a----        15-07-2024     15:46          73728 OnDemandConnRouteHelper.dll
-a----        15-07-2024     15:49         366080 OneBackupHandler.dll
-a----        15-07-2024     15:46         502272 OneCoreCommonProxyStub.dll
-a----        15-07-2024     15:46        8253328 OneCoreUAPCommonProxyStub.dll
-a----        15-07-2024     15:47         709632 OneDriveSettingSyncProvider.dll
-a----        15-07-2024     15:47         182784 OneSettingsClient.dll
-a----        17-11-2023     23:47         238080 onex.dll
-a----        07-12-2019     14:38         113152 onexui.dll
-a----        07-12-2019     14:38           2832 onnxruntime.dll
-a----        15-07-2024     15:46         102832 OOBE-Maintenance.exe
-a----        15-07-2024     15:47        2191360 OpcServices.dll
-a----        02-08-2021     19:21         507712 OpenCL.dll
-a----        07-12-2019     14:39          75776 openfiles.exe
-a----        15-07-2024     15:48        1073152 opengl32.dll
-a----        15-07-2024     15:47         126192 OpenWith.exe
-a----        12-10-2021     06:12         114880 Optane.dll
-a----        12-10-2021     06:12          24256 OptaneEventLogMsg.dll
-a----        15-07-2024     15:48         112640 OptionalFeatures.exe
-a----        21-04-2020     02:25        1032544 ortcengine.dll
-a----        07-12-2019     14:39          27136 osbaseln.dll
-a----        15-07-2024     15:47         674304 osk.exe
-a----        07-12-2019     14:38          10240 OskSupport.dll
-a----        07-12-2019     14:38           9728 osuninst.dll
-a----        07-12-2019     14:38          46920 OutdoorAudioEnvironment.bin
-a----        17-11-2023     23:49         219648 P2P.dll
-a----        07-12-2019     14:39         437760 P2PGraph.dll
-a----        07-12-2019     14:39         207360 p2pnetsh.dll
-a----        17-11-2023     23:49         439808 p2psvc.dll
-a----        15-07-2024     15:49         158192 p9np.dll
-a----        17-11-2023     23:48          12288 pacjsworker.exe
-a----        15-07-2024     15:47          40960 PackagedCWALauncher.exe
-a----        15-07-2024     15:48          96256 packager.dll
-a----        15-07-2024     15:46          66048 PackageStateChangeHandler.dll
-a----        15-07-2024     15:46         241152 PackageStateRoaming.dll
-a----        07-12-2019     14:38          14848 panmap.dll
-a----        15-07-2024     15:47         272384 PasswordEnrollmentManager.dll
-a----        15-07-2024     15:47          47016 PasswordOnWakeSettingFlyout.exe
-a----        07-12-2019     14:39          20480 PATHPING.EXE
-a----        07-12-2019     14:39          67072 pautoenr.dll
-a----        17-11-2023     23:49         973312 PayloadRestrictions.dll
-a----        07-12-2019     14:38          24576 PaymentMediatorServiceProxy.dll
-a----        15-07-2024     15:47         106496 pcacli.dll
-a----        15-07-2024     15:47         102400 pcadm.dll
-a----        17-11-2023     23:48          12800 pcaevts.dll
-a----        15-07-2024     15:47          88064 pcalua.exe
-a----        15-07-2024     15:47         899552 pcasvc.dll
-a----        15-07-2024     15:47         129536 pcaui.dll
-a----        15-07-2024     15:47         206848 pcaui.exe
-a----        07-12-2019     14:38          15360 pcbp.rs
-a----        07-12-2019     14:39            150 pcl.sep
-a----        15-07-2024     15:46        1150880 PCPKsp.dll
-a----        15-07-2024     15:47          60416 PCShellCommonProxyStub.dll
-a----        07-12-2019     14:38         390656 pcsvDevice.dll
-a----        17-11-2023     23:49          16384 pcwrun.exe
-a----        07-12-2019     14:38          22600 pcwum.dll
-a----        15-07-2024     15:48         178176 pcwutl.dll
-a----        15-07-2024     15:47         323584 pdh.dll
-a----        07-12-2019     14:39          62976 pdhui.dll
-a----        07-12-2019     14:38          20992 pegi-pt.rs
-a----        07-12-2019     14:38          20480 pegi.rs
-a----        17-11-2023     23:48         121344 PeopleAPIs.dll
-a----        15-07-2024     15:47         227328 PeopleBand.dll
-a----        15-07-2024     15:49         200704 PerceptionDevice.dll
-a----        07-12-2019     14:39          15872 PerceptionSimulation.ProxyStubs.dll
-a----        15-07-2024     15:48         553984 PerceptionSimulationExtensions.dll
-a----        16-10-2019     03:15        1366268 PerceptionSimulationLeftHandModel.glb
-a----        15-07-2024     15:48         806400 PerceptionSimulationManager.dll
-a----        16-10-2019     03:15        1368296 PerceptionSimulationRightHandModel.glb
-a----        09-08-2024     06:24         140396 perfc009.dat
-a----        17-11-2023     23:48          47616 perfctrs.dll
-a----        07-12-2019     14:42          33424 perfd009.dat
-a----        17-11-2023     23:48          43008 perfdisk.dll
-a----        09-08-2024     06:24         713646 perfh009.dat
-a----        07-12-2019     14:42         297062 perfi009.dat
-a----        07-12-2019     14:39         181760 perfmon.exe
-a----        07-12-2019     14:39         145519 perfmon.msc
-a----        17-11-2023     23:48          27136 perfnet.dll
-a----        17-11-2023     23:48          42496 perfos.dll
-a----        17-11-2023     23:48          46080 perfproc.dll
-a----        09-08-2024     06:24         847168 PerfStringBackup.INI
-a----        07-12-2019     14:39          83456 perftrack.dll
-a----        15-07-2024     15:48          83456 perfts.dll
-a----        15-07-2024     15:47         148992 PersonalizationCSP.dll
-a----        17-11-2023     23:48         111696 phoneactivate.exe
-a----        15-07-2024     15:47         249344 PhoneCallHistoryApis.dll
-a----        15-07-2024     15:47         459264 PhoneOm.dll
-a----        15-07-2024     15:46         111104 PhonePlatformAbstraction.dll
-a----        15-07-2024     15:46         889856 PhoneProviders.dll
-a----        15-07-2024     15:46         954880 PhoneService.dll
-a----        17-11-2023     23:47           2560 PhoneServiceRes.dll
-a----        07-12-2019     14:38           2259 PhoneSystemToastIcon.contrast-white.png
-a----        07-12-2019     14:38           1969 PhoneSystemToastIcon.png
-a----        15-07-2024     15:47         365056 Phoneutil.dll
-a----        07-12-2019     14:38           2560 PhoneutilRes.dll
-a----        15-07-2024     15:47         502272 PhotoMetadataHandler.dll
-a----        15-07-2024     15:49         619520 PhotoScreensaver.scr
-a----        07-12-2019     15:22         350208 photowiz.dll
-a----        15-07-2024     15:46         128208 PickerHost.exe
-a----        15-07-2024     15:47         389120 PickerPlatform.dll
-a----        07-12-2019     14:39          46592 pid.dll
-a----        17-11-2023     23:48        1088896 pidgenx.dll
-a----        07-12-2019     14:39          35840 pifmgr.dll
-a----        15-07-2024     15:47         196096 PimIndexMaintenance.dll
-a----        17-11-2023     23:48          63488 PimIndexMaintenanceClient.dll
-a----        15-07-2024     15:47         986112 Pimstore.dll
-a----        15-07-2024     15:46         112128 PinEnrollmentBroker.exe
-a----        15-07-2024     15:46         198144 PinEnrollmentHelper.dll
-a----        07-12-2019     14:39          22528 PING.EXE
-a----        15-07-2024     15:46         884384 pkeyhelper.dll
-a----        15-07-2024     15:48         250880 PkgMgr.exe
-a----        15-07-2024     15:48         682464 PktMon.exe
-a----        15-07-2024     15:48          41472 PktMonApi.dll
-a----        15-07-2024     15:47         300032 pku2u.dll
-a----        07-12-2019     14:39        1493504 pla.dll
-a----        07-12-2019     14:39          10752 plasrv.exe
-a----        15-07-2024     15:47          79872 playlistfolder.dll
-a----        17-11-2023     23:47          90112 PlaySndSrv.dll
-a----        17-11-2023     23:49         392704 PlayToDevice.dll
-a----        15-07-2024     15:48         614912 PlayToManager.dll
-a----        15-07-2024     15:48         164352 playtomenu.dll
-a----        15-07-2024     15:49         301568 PlayToReceiver.dll
-a----        17-11-2023     23:49          37888 PlayToStatusProvider.dll
-a----        17-11-2023     23:49          63968 ploptin.dll
-a----        17-11-2023     23:49          67584 pngfilt.dll
-a----        15-07-2024     15:47        2176512 pnidui.dll
-a----        17-11-2023     23:49         141312 pnpclean.dll
-a----        15-07-2024     15:47          91648 pnppolicy.dll
-a----        07-12-2019     14:39          15872 pnpts.dll
-a----        07-12-2019     14:39          49664 pnpui.dll
-a----        17-11-2023     23:49          62976 PnPUnattend.exe
-a----        15-07-2024     15:47         329728 pnputil.exe
-a----        15-07-2024     15:48         112640 PNPXAssoc.dll
-a----        07-12-2019     14:39          57856 PNPXAssocPrx.dll
-a----        07-12-2019     14:39          28160 pnrpauto.dll
-a----        17-11-2023     23:49          85504 Pnrphc.dll
-a----        17-11-2023     23:49          89088 pnrpnsp.dll
-a----        17-11-2023     23:49         352768 pnrpsvc.dll
-a----        15-07-2024     15:47         648400 policymanager.dll
-a----        15-07-2024     15:47         290304 policymanagerprecheck.dll
-a----        17-11-2023     23:48         354304 polstore.dll
-a----        25-05-2024     09:34         497664 poqexec.exe
-a----        15-07-2024     15:49         642048 PortableDeviceApi.dll
-a----        17-11-2023     23:50         128000 PortableDeviceClassExtension.dll
-a----        17-11-2023     23:50          69632 PortableDeviceConnectApi.dll
-a----        17-11-2023     23:50          74752 PortableDeviceStatus.dll
-a----        17-11-2023     23:49         162816 PortableDeviceSyncProvider.dll
-a----        17-11-2023     23:50         186880 PortableDeviceTypes.dll
-a----        17-11-2023     23:50         159232 PortableDeviceWiaCompat.dll
-a----        07-12-2019     14:39          34304 posetup.dll
-a----        15-07-2024     15:47          44032 pospaymentsworker.exe
-a----        17-11-2023     23:48          68096 POSyncServices.dll
-a----        07-12-2019     14:38          39936 pots.dll
-a----        15-07-2024     15:48         239616 powercfg.cpl
-a----        07-12-2019     14:39          96256 powercfg.exe
-a----        15-07-2024     15:48         212480 powercpl.dll
-a----        17-11-2023     23:48         296648 powrprof.dll
-a----        15-07-2024     15:47          70656 prauthproviders.dll
-a----        07-12-2019     14:40         282624 PresentationHost.exe
-a----        07-12-2019     14:40          83456 PresentationHostProxy.dll
-a----        15-07-2024     15:47          30208 prevhost.exe
-a----        07-12-2019     14:38          13824 prflbmsg.dll
-a----        17-11-2023     23:49          17408 print.exe
-a----        15-07-2024     15:47         373760 Print.PrintSupport.Source.dll
-a----        15-07-2024     15:47          93696 Print.Workflow.Source.dll
-a----        15-07-2024     15:46          86528 PrinterCleanupTask.dll
-a----        15-07-2024     15:46          92672 printfilterpipelineprxy.dll
-a----        15-07-2024     15:46         748544 printfilterpipelinesvc.exe
-a----        17-11-2023     23:47          77312 PrintIsolationHost.exe
-a----        15-07-2024     15:46          97792 PrintIsolationProxy.dll
-a----        15-07-2024     15:47          73216 PrintPlatformConfig.dll
-a----        15-07-2024     15:47         752128 PrintRenderAPIHost.DLL
-a----        15-07-2024     15:47          61952 printticketvalidation.dll
-a----        15-07-2024     15:47         757760 printui.dll
-a----        17-11-2023     23:49          64000 printui.exe
-a----        15-07-2024     15:47         463360 PrintWorkflowService.dll
-a----        15-07-2024     15:48         146432 PrintWSDAHost.dll
-a----        06-12-2019     22:06        5739008 prm0009.dll
-a----        17-11-2023     23:49         183808 prncache.dll
-a----        17-11-2023     23:49         239104 prnfldr.dll
-a----        15-07-2024     15:47         294912 prnntfy.dll
-a----        17-11-2023     23:49         190464 prntvpt.dll
-a----        17-11-2023     23:48          37888 ProductEnumerator.dll
-a----        15-07-2024     15:47         134496 profapi.dll
-a----        15-07-2024     15:47         178776 profext.dll
-a----        15-07-2024     15:47         140288 profprov.dll
-a----        15-07-2024     15:47         488448 profsvc.dll
-a----        15-07-2024     15:47         175616 profsvcext.dll
-a----        15-07-2024     15:47        1004232 propsys.dll
-a----        15-07-2024     15:47          68096 proquota.exe
-a----        15-07-2024     15:46         684544 provcore.dll
-a----        15-07-2024     15:46          99840 provdatastore.dll
-a----        17-11-2023     23:47          22016 provdiagnostics.dll
-a----        15-07-2024     15:46         382464 provengine.dll
-a----        15-07-2024     15:46         279040 provhandlers.dll
-a----        15-07-2024     15:49          78336 provisioningcommandscsp.dll
-a----        15-07-2024     15:46         256000 provisioningcsp.dll
-a----        15-07-2024     15:46         222208 ProvisioningHandlers.dll
-a----        15-07-2024     15:49          62976 provlaunch.exe
-a----        15-07-2024     15:49         111104 provmigrate.dll
-a----        15-07-2024     15:46         295424 provops.dll
-a----        15-07-2024     15:46         139776 provpackageapidll.dll
-a----        15-07-2024     15:49         203264 provplatformdesktop.dll
-a----        15-07-2024     15:46          79360 ProvPluginEng.dll
-a----        15-07-2024     15:49         487424 provsvc.dll
-a----        15-07-2024     15:49          80896 ProvSysprep.dll
-a----        07-12-2019     14:38         319488 provthrd.dll
-a----        15-07-2024     15:46          87040 provtool.exe
-a----        07-12-2019     14:38         171008 ProximityCommon.dll
-a----        17-11-2023     23:48          17408 ProximityCommonPal.dll
-a----        15-07-2024     15:46          26624 ProximityRtapiPal.dll
-a----        17-11-2023     23:48         320512 ProximityService.dll
-a----        15-07-2024     15:46          59392 ProximityServicePal.dll
-a----        15-07-2024     15:49         271184 ProximityUxHost.exe
-a----        07-12-2019     14:38          21144 prproc.exe
-a----        07-12-2019     14:38          86528 prvdmofcomp.dll
-a----        17-11-2023     23:48          20328 psapi.dll
-a----        07-12-2019     14:39             51 pscript.sep
-a----        07-12-2019     14:38          76600 PSHED.DLL
-a----        17-11-2023     23:49         599552 psisdecd.dll
-a----        07-12-2019     14:39          99840 psisrndr.ax
-a----        07-12-2019     14:38          54784 PSModuleDiscoveryProvider.dll
-a----        07-12-2019     14:38           4148 psmodulediscoveryprovider.mof
-a----        15-07-2024     15:47         763904 PsmServiceExtHost.dll
-a----        17-11-2023     23:48         247296 psmsrv.dll
-a----        17-11-2023     23:50         237568 psr.exe
-a----        07-12-2019     14:39          16384 pstask.dll
-a----        07-12-2019     14:38          16384 pstorec.dll
-a----        15-07-2024     15:46         217088 ptpprov.dll
-a----        17-11-2023     23:49         204800 puiapi.dll
-a----        17-11-2023     23:49         462848 puiobj.dll
-a----        15-07-2024     15:47         349696 PushToInstall.dll
-a----        17-11-2023     23:49         331264 pwlauncher.dll
-a----        07-12-2019     14:39          35840 pwlauncher.exe
-a----        07-12-2019     14:40          98304 pwrshplugin.dll
-a----        17-11-2023     23:49          32256 pwsso.dll
-a----        07-12-2019     14:39         157696 qasf.dll
-a----        07-12-2019     14:39         199680 qcap.dll
-a----        07-12-2019     14:39         252416 qdv.dll
-a----        17-11-2023     23:49         398848 qdvd.dll
-a----        15-07-2024     15:48         667648 qedit.dll
-a----        07-12-2019     14:39           2560 qedwipes.dll
-a----        15-07-2024     15:46        1481728 qmgr.dll
-a----        25-09-2023     20:43         483712 QualityUpdateAssistant.dll
-a----        17-11-2023     23:49        1687552 quartz.dll
-a----        15-07-2024     15:47         111104 Query.dll
-a----        15-07-2024     15:47         367104 QuickActionsDataModel.dll
-a----        15-07-2024     15:49         951808 quickassist.exe
-a----        15-07-2024     15:47         582144 QuietHours.dll
-a----        17-11-2023     23:49         287232 qwave.dll
-a----        07-12-2019     14:39          35840 RacEngn.dll
-a----        17-11-2023     23:50         133632 racpldlg.dll
-a----        07-12-2019     14:39         101888 radardt.dll
-a----        07-12-2019     14:39          72704 radarrs.dll
-a----        15-07-2024     15:47         416768 RADCUI.dll
-a----        17-11-2023     23:49          17408 rasadhlp.dll
-a----        15-07-2024     15:47        1016320 rasapi32.dll
-a----        17-11-2023     23:49         111616 rasauto.dll
-a----        17-11-2023     23:49          18432 rasautou.exe
-a----        15-07-2024     15:47         190464 raschap.dll
-a----        17-11-2023     23:49         101888 raschapext.dll
-a----        07-12-2019     14:39           1820 rasctrnm.h
-a----        07-12-2019     14:39          22016 rasctrs.dll
-a----        15-07-2024     15:47         509952 rascustom.dll
-a----        17-11-2023     23:49          87040 rasdiag.dll
-a----        17-11-2023     23:49          20992 rasdial.exe
-a----        17-11-2023     23:49         616960 rasdlg.dll
-a----        17-11-2023     23:50         135168 raserver.exe
-a----        15-07-2024     15:47         554496 rasgcw.dll
-a----        17-11-2023     23:49         188928 rasman.dll
-a----        15-07-2024     15:47        1015296 rasmans.dll
-a----        07-12-2019     14:39          61952 rasmbmgr.dll
-a----        15-07-2024     15:47         383488 RasMediaManager.dll
-a----        17-11-2023     23:49         310272 RASMM.dll
-a----        17-11-2023     23:49         360960 rasmontr.dll
-a----        07-12-2019     14:39          36864 rasphone.exe
-a----        17-11-2023     23:49         237056 rasplap.dll
-a----        15-07-2024     15:49         333824 rasppp.dll
-a----        17-11-2023     23:49         253952 rastapi.dll
-a----        15-07-2024     15:47         426496 rastls.dll
-a----        15-07-2024     15:47         261120 rastlsext.dll
-a----        15-07-2024     15:49         672256 rdbui.dll
-a----        17-11-2023     23:49         130544 rdp4vs.dll
-a----        15-07-2024     15:47        1570288 rdpbase.dll
-a----        07-12-2019     14:39          11264 rdpcfgex.dll
-a----        15-07-2024     15:48         453632 rdpclip.exe
-a----        15-07-2024     15:48        1285120 rdpcore.dll
-a----        15-07-2024     15:48        1631232 rdpcorets.dll
-a----        17-11-2023     23:49          43008 rdpcredentialprovider.dll
-a----        17-11-2023     23:49         433664 rdpencom.dll
-a----        17-11-2023     23:49         310088 rdpendp.dll
-a----        07-12-2019     14:39         184832 rdpinput.exe
-a----        13-07-2021     10:47        2371072 rdpnano.dll
-a----        17-11-2023     23:49         249856 RdpRelayTransport.dll
-a----        17-11-2023     23:49          57344 RdpSa.exe
-a----        17-11-2023     23:49          40960 RdpSaProxy.exe
-a----        07-12-2019     14:39          15360 RdpSaPs.dll
-a----        17-11-2023     23:49          34304 RdpSaUacHelper.exe
-a----        15-07-2024     15:47        1887728 rdpserverbase.dll
-a----        15-07-2024     15:47        1513472 rdpsharercom.dll
-a----        17-11-2023     23:49          98264 rdpudd.dll
-a----        17-11-2023     23:49         332800 rdpviewerax.dll
-a----        07-12-2019     14:38          48640 rdrleakdiag.exe
-a----        17-11-2023     23:49          96768 RDSAppXHelper.dll
-a----        15-07-2024     15:48         228864 rdsdwmdr.dll
-a----        15-07-2024     15:46          74752 rdsxvmaudio.dll
-a----        17-11-2023     23:49          89600 rdvvmtransport.dll
-a----        15-07-2024     15:49         734720 RDXService.dll
-a----        15-07-2024     15:49         425472 RDXTaskFactory.dll
-a----        15-07-2024     15:46          57856 readCloudDataSettings.exe
-a----        15-07-2024     15:47        1141224 ReAgent.dll
-a----        17-11-2023     23:48          44544 ReAgentc.exe
-a----        07-12-2019     14:38          13824 ReAgentTask.dll
-a----        17-11-2023     23:49         197632 recdisc.exe
-a----        07-12-2019     14:39          14336 recover.exe
-a----        15-07-2024     15:48         132608 recovery.dll
-a----        15-07-2024     15:48         946176 RecoveryDrive.exe
-a----        15-07-2024     15:47        1024000 refsutil.exe
-a----        07-12-2019     14:39          77312 reg.exe
-a----        17-11-2023     23:49         219136 regapi.dll
-a----        17-11-2023     23:48          52224 RegCtrl.dll
-a----        07-12-2019     14:39          11776 regedt32.exe
-a----        07-12-2019     14:39          15872 regidle.dll
-a----        07-12-2019     14:39          48128 regini.exe
-a----        07-12-2019     14:38          30208 Register-CimProvider.exe
-a----        22-03-2024     13:02         172032 regsvc.dll
-a----        07-12-2019     14:39          25088 regsvr32.exe
-a----        07-12-2019     14:38          36344 reguwpapi.dll
-a----        07-12-2019     14:38         181760 ReInfo.dll
-a----        17-11-2023     23:48         122880 rekeywiz.exe
-a----        17-11-2023     23:49          53760 relog.exe
-a----        15-07-2024     15:47         187904 RelPost.exe
-a----        15-07-2024     15:46          92104 remoteaudioendpoint.dll
-a----        17-11-2023     23:49          90624 remotepg.dll
-a----        07-12-2019     14:38          13312 RemotePosWorker.exe
-a----        07-12-2019     14:39         108032 remotesp.tsp
-a----        07-12-2019     14:38           1613 RemoteSystemToastIcon.contrast-white.png
-a----        07-12-2019     14:38           1124 RemoteSystemToastIcon.png
-a----        15-07-2024     15:48          63488 RemoteWipeCSP.dll
-a----        15-07-2024     15:46          68608 RemovableMediaProvisioningPlugin.dll
-a----        15-07-2024     15:48          74240 RemoveDeviceContextHandler.dll
-a----        07-12-2019     14:39          14848 RemoveDeviceElevated.dll
-a----        07-12-2019     14:39            256 removerootporterr.mof
-a----        17-11-2023     23:50           6656 rendezvousSession.tlb
-a----        07-12-2019     15:22         129024 repair-bde.exe
-a----        17-11-2023     23:49          22528 replace.exe
-a----        15-07-2024     15:48         142336 ReportingCSP.dll
-a----        07-12-2019     15:22         250696 RESAMPLEDMO.DLL
-a----        07-12-2019     14:39         113152 ResBParser.dll
-a----        15-07-2024     15:48        1257984 reseteng.dll
-a----        15-07-2024     15:48        2434016 ResetEngine.dll
-a----        17-11-2023     23:49          21480 ResetEngine.exe
-a----        15-07-2024     15:48         192512 ResetEngOnline.dll
-a----        07-12-2019     14:39         110592 resmon.exe
-a----        15-07-2024     15:48         528384 ResourceMapper.dll
-a----        15-07-2024     15:46          72992 ResourcePolicyClient.dll
-a----        15-07-2024     15:46         149984 ResourcePolicyServer.dll
-a----        07-12-2019     14:39           9571 ResPriHMImageList
-a----        07-12-2019     14:39           9196 ResPriHMImageListLowCost
-a----        07-12-2019     14:39           8977 ResPriImageList
-a----        07-12-2019     14:39           8690 ResPriImageListLowCost
-a----        07-12-2019     14:39            714 RestartManager.mof
-a----        07-12-2019     14:39            176 RestartManagerUninstall.mof
-a----        07-12-2019     14:38            759 RestartNowPower_80.contrast-black.png
-a----        07-12-2019     14:38            785 RestartNowPower_80.contrast-white.png
-a----        07-12-2019     14:38            759 RestartNowPower_80.png
-a----        07-12-2019     14:38           1091 RestartTonight_80.png
-a----        07-12-2019     14:38           1091 RestartTonight_80_contrast-black.png
-a----        07-12-2019     14:38           1003 RestartTonight_80_contrast-white.png
-a----        15-07-2024     15:48         615424 resutils.dll
-a----        07-12-2019     14:38         181760 rgb9rast.dll
-a----        15-07-2024     15:48         154112 Ribbons.scr
-a----        07-12-2019     14:39         612352 riched20.dll
-a----        07-12-2019     14:39          10240 riched32.dll
-a----        07-12-2019     14:39          58880 rilproxy.dll
-a----        15-07-2024     15:46         152576 RjvMDMConfig.dll
-a----        17-11-2023     23:47         579584 RMActivate.exe
-a----        17-11-2023     23:47         607744 RMActivate_isv.exe
-a----        17-11-2023     23:47         501760 RMActivate_ssp.exe
-a----        07-12-2019     14:38         501760 RMActivate_ssp_isv.exe
-a----        15-07-2024     15:47         152576 RMapi.dll
-a----        17-11-2023     23:48         164392 rmclient.dll
-a----        07-12-2019     14:39          18432 RmClient.exe
-a----        15-07-2024     15:46         104960 RMSRoamingSecurity.dll
-a----        15-07-2024     15:47         142848 rmttpmvscmgrsvr.exe
-a----        07-12-2019     14:39           2560 rnr20.dll
-a----        17-11-2023     23:48          49664 RoamingSecurity.dll
-a----        15-07-2024     15:48         172544 Robocopy.exe
-a----        07-12-2019     14:38         234432 rometadata.dll
-a----        07-12-2019     14:39           3468 rootporterr.mof
-a----        17-11-2023     23:49          50688 RotMgr.dll
-a----        07-12-2019     14:39          24576 ROUTE.EXE
-a----        17-11-2023     23:48          84480 RpcEpMap.dll
-a----        17-11-2023     23:48         208896 rpchttp.dll
-a----        07-12-2019     14:38          10240 RpcNs4.dll
-a----        07-12-2019     14:38          34304 rpcnsh.dll
-a----        07-12-2019     14:38          31744 RpcPing.exe
-a----        15-07-2024     15:47        1189680 rpcrt4.dll
-a----        17-11-2023     23:48          66296 RpcRtRemote.dll
-a----        15-07-2024     15:47        1324032 rpcss.dll
-a----        17-11-2023     23:50          48128 rrinstaller.exe
-a----        17-11-2023     23:48         208272 rsaenh.dll
-a----        15-07-2024     15:48         133632 rshx32.dll
-a----        12-10-2021     06:12          27328 RstMwEventLogMsg.dll
-a----        15-07-2024     15:47         207360 RstrtMgr.dll
-a----        15-07-2024     15:49         274432 rstrui.exe
-a----        15-07-2024     15:47          48640 rtffilt.dll
-a----        20-01-2024     11:02         185344 rtm.dll
-a----        21-04-2020     02:25        1091936 rtmcodecs.dll
-a----        15-07-2024     15:46         512512 RTMediaFrame.dll
-a----        21-04-2020     02:25          56672 rtmmvrortc.dll
-a----        21-04-2020     02:25        1354080 rtmpal.dll
-a----        21-04-2020     02:25        4898144 rtmpltfm.dll
-a----        23-02-2024     23:41          70144 rtutils.dll
-a----        15-07-2024     15:46         191816 RTWorkQ.dll
-a----        15-07-2024     15:46         100352 RuleBasedDS.dll
-a----        17-11-2023     23:49          20480 runas.exe
-a----        15-07-2024     15:47          89600 rundll32.exe
-a----        15-07-2024     15:47          61440 runexehelper.exe
-a----        15-07-2024     15:46          74240 RunLegacyCPLElevated.exe
-a----        15-07-2024     15:47          61952 runonce.exe
-a----        15-07-2024     15:46         102832 RuntimeBroker.exe
-a----        17-11-2023     23:48          82944 samcli.dll
-a----        15-07-2024     15:47         139264 samlib.dll
-a----        15-07-2024     15:47         941056 samsrv.dll
-a----        07-12-2019     14:38          14848 sas.dll
-a----        07-12-2019     14:39         964096 sbe.dll
-a----        07-12-2019     14:39         198144 sbeio.dll
-a----        07-12-2019     14:39          66048 sberes.dll
-a----        17-11-2023     23:49          38296 sbresources.dll
-a----        17-11-2023     23:48          23040 sbservicetrigger.dll
-a----        07-12-2019     14:39          72192 sc.exe
-a----        15-07-2024     15:48         113664 ScanPlugin.dll
-a----        17-11-2023     23:49         297472 scansetting.dll
-a----        13-03-2021     08:58          20227 scanstate.log
-a----        15-07-2024     15:47          51200 SCardBi.dll
-a----        15-07-2024     15:47          84480 SCardDlg.dll
-a----        15-07-2024     15:47         265216 SCardSvr.dll
-a----        07-12-2019     14:40          10429 ScavengeSpace.xml
-a----        07-12-2019     14:40          67072 scavengeui.dll
-a----        18-11-2019     19:16         482432 ScDetour.Dll
-a----        15-07-2024     15:47         205312 ScDeviceEnum.dll
-a----        15-07-2024     15:47         346112 scecli.dll
-a----        15-07-2024     15:47         583680 scesrv.dll
-a----        15-07-2024     15:47         600576 schannel.dll
-a----        17-11-2023     23:48          23040 schedcli.dll
-a----        17-11-2023     23:49         813056 schedsvc.dll
-a----        07-12-2019     14:38            538 ScheduleTime_80.contrast-black.png
-a----        07-12-2019     14:38            551 ScheduleTime_80.contrast-white.png
-a----        07-12-2019     14:38            538 ScheduleTime_80.png
-a----        17-11-2023     23:49         235008 schtasks.exe
-a----        15-07-2024     15:47         262656 scksp.dll
-a----        17-11-2023     23:49          89600 scripto.dll
-a----        15-07-2024     15:46          39936 scrnsave.scr
-a----        29-10-2023     08:36         228864 scrobj.dll
-a----        15-07-2024     15:47         229376 scrrun.dll
-a----        29-09-2021     08:12         312352 SCSANDBOXAPI.DLL
-a----        18-11-2019     19:17         224376 ScSecAuth.Dll
-a----        17-11-2023     23:48          24576 sdbinst.exe
-a----        17-11-2023     23:50          51712 sdchange.exe
-a----        15-07-2024     15:48        1265152 sdclt.exe
-a----        15-07-2024     15:48         794112 sdcpl.dll
-a----        15-07-2024     15:47         430592 SDDS.dll
-a----        17-11-2023     23:49        1244672 sdengin2.dll
-a----        07-12-2019     14:39          37224 SDFHost.dll
-a----        07-12-2019     14:38          36352 sdhcinst.dll
-a----        15-07-2024     15:48         232960 sdiageng.dll
-a----        15-07-2024     15:48          40448 sdiagnhost.exe
-a----        07-12-2019     14:39         192512 sdiagprv.dll
-a----        15-07-2024     15:48          68096 sdiagschd.dll
-a----        17-11-2023     23:49         543232 sdohlp.dll
-a----        17-11-2023     23:49         155648 sdrsvc.dll
-a----        17-11-2023     23:49         129536 sdshext.dll
-a----        23-02-2021     21:44        1435520 SEAPO64.dll
-a----        10-11-2022     23:13         245240 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0215.zip
-a----        10-11-2022     23:13         991995 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0222.zip
-a----        10-11-2022     23:13         137160 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0225.zip
-a----        10-11-2022     23:13        2970037 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0236.zip
-a----        10-11-2022     23:13         687773 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0245.zip
-a----        10-11-2022     23:13         652538 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0256.zip
-a----        10-11-2022     23:13         582339 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0274.zip
-a----        10-11-2022     23:13         204671 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0282.zip
-a----        10-11-2022     23:13        1002370 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0285.zip
-a----        10-11-2022     23:13         209956 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0287.zip
-a----        10-11-2022     23:13          41375 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0293.zip
-a----        10-11-2022     23:13         492057 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0295.zip
-a----        10-11-2022     23:13         245518 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0671.zip
-a----        10-11-2022     23:13         243645 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0701.zip
-a----        10-11-2022     23:13         489946 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0897.zip
-a----        10-11-2022     23:13         123393 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_1220.zip
-a----        10-11-2022     23:13          41411 SEAPODAT.INTELAUDIO.CTLR_DEV_34C8&LINKTYPE_05&DEVTYPE_05&VEN_8086&DEV_AE35.zip
-a----        10-11-2022     23:13          41278 SEAPODAT.INTELAUDIO.CTLR_DEV_A0C8&LINKTYPE_05&DEVTYPE_05&VEN_8086&DEV_AE35.zip
-a----        10-11-2022     23:13          48076 SEAPODAT.INTELAUDIO.DIF_0001&UIF_0000&FUNC_01&VEN_10EC&DEV_0274.zip
-a----        10-11-2022     23:13          41435 SEAPODAT.INTELAUDIO.DSP_CTLR_DEV_A0C8&VEN_8086&DEV_0222.zip
-a----        10-11-2022     23:13         733247 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0215.zip
-a----        10-11-2022     23:13          48365 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0225.zip
-a----        10-11-2022     23:13        2568404 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0236.zip
-a----        10-11-2022     23:13        2134148 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0245.zip
-a----        10-11-2022     23:13         341050 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0256.zip
-a----        10-11-2022     23:13         454524 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0274.zip
-a----        10-11-2022     23:13        2716858 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0285.zip
-a----        10-11-2022     23:13         395156 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0287.zip
-a----        10-11-2022     23:13          41377 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0293.zip
-a----        10-11-2022     23:13         533606 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0295.zip
-a----        10-11-2022     23:13          48350 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0298.zip
-a----        10-11-2022     23:13         123473 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0897.zip
-a----        10-11-2022     23:13         123422 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_1220.zip
-a----        30-10-2020     08:24          40314 SEAPODAT.zip
-a----        15-07-2024     15:47         402944 Search.ProtocolHandler.MAPI2.dll
-a----        15-07-2024     15:47         272896 SearchFilterHost.exe
-a----        15-07-2024     15:47         413184 SearchFolder.dll
-a----        15-07-2024     15:47         935424 SearchIndexer.exe
-a----        15-07-2024     15:47         419328 SearchProtocolHost.exe
-a----        15-07-2024     15:46          62976 SebBackgroundManagerPolicy.dll
-a----        23-02-2021     21:44         288960 SECCNH64.exe
-a----        15-07-2024     15:48        1322976 SecConfig.efi
-a----        07-12-2019     14:39          41984 SecEdit.exe
-a----        15-07-2024     15:47         645296 sechost.dll
-a----        07-12-2019     14:38          10752 secinit.exe
-a----        17-11-2023     23:49          32768 seclogon.dll
-a----        23-02-2021     21:44        1176256 SECOCL64.exe
-a----        23-02-2021     21:44        1865824 SECOMN64.dll
-a----        23-02-2021     21:44         596184 SECOMN64.exe
-a----        17-11-2023     23:47         402432 secproc.dll
-a----        17-11-2023     23:47         399872 secproc_isv.dll
-a----        17-11-2023     23:47         112128 secproc_ssp.dll
-a----        07-12-2019     14:38         111616 secproc_ssp_isv.dll
-a----        17-11-2023     23:49          28672 secur32.dll
-a----        15-07-2024     15:48          98816 SecureBootEncodeUEFI.exe
-a----        23-02-2024     23:41         923000 securekernel.exe
-a----        15-07-2024     15:46         133120 SecureTimeAggregator.dll
-a----        07-12-2019     14:39           5632 security.dll
-a----        07-12-2019     14:38           5783 SecurityAndMaintenance.png
-a----        07-12-2019     14:38           2613 SecurityAndMaintenance_Alert.png
-a----        07-12-2019     14:38           6873 SecurityAndMaintenance_Error.png
-a----        15-07-2024     15:49         205592 SecurityCenterBroker.dll
-a----        17-11-2023     23:49          43064 SecurityCenterBrokerPS.dll
-a----        15-07-2024     15:46         443760 SecurityHealthAgent.dll
-a----        15-07-2024     15:46          99184 SecurityHealthHost.exe
-a----        17-11-2023     23:48         120176 SecurityHealthProxyStub.dll
-a----        15-07-2024     15:46         987616 SecurityHealthService.exe
-a----        15-07-2024     15:47         961536 SecurityHealthSSO.dll
-a----        15-07-2024     15:47          86016 SecurityHealthSystray.exe
-a----        25-09-2023     20:43         588656 sedplugins.dll
-a----        23-02-2021     21:44        1714712 SEHDHF64.dll
-a----        23-02-2021     21:44        1479768 SEHDRA64.dll
-a----        07-12-2019     14:38          41472 SEMgrPS.dll
-a----        15-07-2024     15:47        1223680 SEMgrSvc.dll
-a----        15-07-2024     15:48         147968 sendmail.dll
-a----        07-12-2019     14:39          77824 Sens.dll
-a----        07-12-2019     14:39          14848 SensApi.dll
-a----        15-07-2024     15:47        1265152 SensorDataService.exe
-a----        07-12-2019     14:38          27648 SensorPerformanceEvents.dll
-a----        15-07-2024     15:47         417280 SensorsApi.dll
-a----        17-11-2023     23:48         142848 SensorsClassExtension.dll
-a----        07-12-2019     14:38           2560 SensorsCpl.dll
-a----        15-07-2024     15:47         467456 SensorService.dll
-a----        17-11-2023     23:48          73024 SensorsNativeApi.dll
-a----        15-07-2024     15:47         221120 SensorsNativeApi.V2.dll
-a----        15-07-2024     15:47         162760 SensorsUtilsV2.dll
-a----        15-07-2024     15:47         181760 sensrsvc.dll
-a----        07-12-2019     14:39          19968 serialui.dll
-a----        15-07-2024     15:47         716544 services.exe
-a----        07-12-2019     14:39          92746 services.msc
-a----        15-07-2024     15:47         214512 ServicingUAPI.dll
-a----        07-12-2019     14:39          25600 serwvdrv.dll
-a----        15-07-2024     15:48         543232 SessEnv.dll
-a----        17-11-2023     23:49          88368 sessionmsg.exe
-a----        07-12-2019     14:38          92160 setbcdlocale.dll
-a----        15-07-2024     15:47         107008 sethc.exe
-a----        17-11-2023     23:48          30208 SetNetworkLocation.dll
-a----        17-11-2023     23:48          38912 SetNetworkLocationFlyout.dll
-a----        17-11-2023     23:48          36864 SetProxyCredential.dll
-a----        07-12-2019     14:39          30720 setspn.exe
-a----        15-07-2024     15:46         166912 SettingMonitor.dll
-a----        07-12-2019     14:38           8192 settings.dat
-a----        15-07-2024     15:47         600576 SettingsEnvironment.Desktop.dll
-a----        15-07-2024     15:47         150016 SettingsExtensibilityHandlers.dll
-a----        15-07-2024     15:46         272896 SettingsHandlers_Accessibility.dll
-a----        15-07-2024     15:49         243712 SettingsHandlers_AnalogShell.dll
-a----        15-07-2024     15:47         103424 SettingsHandlers_AppControl.dll
-a----        15-07-2024     15:46         159232 SettingsHandlers_AppExecutionAlias.dll
-a----        15-07-2024     15:47         332800 SettingsHandlers_Authentication.dll
-a----        15-07-2024     15:46         155136 SettingsHandlers_BackgroundApps.dll
-a----        15-07-2024     15:47         250368 SettingsHandlers_BatteryUsage.dll
-a----        15-07-2024     15:47         155648 SettingsHandlers_BrowserDeclutter.dll
-a----        15-07-2024     15:46         303104 SettingsHandlers_CapabilityAccess.dll
-a----        15-07-2024     15:49         199680 SettingsHandlers_Clipboard.dll
-a----        15-07-2024     15:46         143872 SettingsHandlers_ClosedCaptioning.dll
-a----        15-07-2024     15:47         180224 SettingsHandlers_ContentDeliveryManager.dll
-a----        15-07-2024     15:47         349184 SettingsHandlers_Cortana.dll
-a----        15-07-2024     15:47         608256 SettingsHandlers_Devices.dll
-a----        15-07-2024     15:47         450560 SettingsHandlers_Display.dll
-a----        15-07-2024     15:46         497664 SettingsHandlers_Flights.dll
-a----        15-07-2024     15:47         371712 SettingsHandlers_Fonts.dll
-a----        15-07-2024     15:47         162816 SettingsHandlers_ForceSync.dll
-a----        15-07-2024     15:47         281088 SettingsHandlers_Gaming.dll
-a----        15-07-2024     15:47          96256 SettingsHandlers_Geolocation.dll
-a----        15-07-2024     15:47         250368 SettingsHandlers_Gpu.dll
-a----        15-07-2024     15:49         462336 SettingsHandlers_HoloLens_Environment.dll
-a----        15-07-2024     15:47        1237504 SettingsHandlers_IME.dll
-a----        15-07-2024     15:47         194560 SettingsHandlers_InkingTypingPrivacy.dll
-a----        15-07-2024     15:46         339968 SettingsHandlers_InputPersonalization.dll
-a----        15-07-2024     15:47         866304 SettingsHandlers_Language.dll
-a----        15-07-2024     15:47         338432 SettingsHandlers_ManagePhone.dll
-a----        15-07-2024     15:46         266240 SettingsHandlers_Maps.dll
-a----        15-07-2024     15:47         102400 SettingsHandlers_Mouse.dll
-a----        15-07-2024     15:47         502272 SettingsHandlers_Notifications.dll
-a----        15-07-2024     15:47        3571712 SettingsHandlers_nt.dll
-a----        15-07-2024     15:46         190976 SettingsHandlers_OneCore_BatterySaver.dll
-a----        15-07-2024     15:46         111104 SettingsHandlers_OneCore_PowerAndSleep.dll
-a----        15-07-2024     15:47         103424 SettingsHandlers_OneDriveBackup.dll
-a----        15-07-2024     15:47         438784 SettingsHandlers_OptionalFeatures.dll
-a----        15-07-2024     15:47         560640 SettingsHandlers_PCDisplay.dll
-a----        15-07-2024     15:47         138240 SettingsHandlers_Pen.dll
-a----        15-07-2024     15:47         116224 SettingsHandlers_QuickActions.dll
-a----        15-07-2024     15:47         346112 SettingsHandlers_Region.dll
-a----        15-07-2024     15:48         141824 SettingsHandlers_SharedExperiences_Rome.dll
-a----        15-07-2024     15:46         228720 SettingsHandlers_SIUF.dll
-a----        15-07-2024     15:47         401920 SettingsHandlers_SpeechPrivacy.dll
-a----        15-07-2024     15:46         153088 SettingsHandlers_Startup.dll
-a----        15-07-2024     15:46         805872 SettingsHandlers_StorageSense.dll
-a----        15-07-2024     15:48         196952 SettingsHandlers_Troubleshoot.dll
-a----        15-07-2024     15:47         409088 SettingsHandlers_User.dll
-a----        15-07-2024     15:46         402944 SettingsHandlers_UserAccount.dll
-a----        15-07-2024     15:46         115200 SettingsHandlers_UserExperience.dll
-a----        15-07-2024     15:46         448000 SettingsHandlers_WorkAccess.dll
-a----        15-07-2024     15:46         714240 SettingSync.dll
-a----        15-07-2024     15:47        1128960 SettingSyncCore.dll
-a----        15-07-2024     15:46         640512 SettingSyncDownloadHelper.dll
-a----        15-07-2024     15:47         970632 SettingSyncHost.exe
-a----        15-07-2024     15:47        4674872 setupapi.dll
-a----        15-07-2024     15:47         157568 setupcl.dll
-a----        17-11-2023     23:48          10240 setupcl.exe
-a----        15-07-2024     15:48         209408 setupcln.dll
-a----        07-12-2019     14:39          20792 setupetw.dll
-a----        17-11-2023     23:48         137216 setupugc.exe
-a----        07-12-2019     14:39          58368 setx.exe
-a----        17-11-2023     23:49          12864 sfc.dll
-a----        07-12-2019     14:38          50176 sfc.exe
-a----        15-07-2024     15:47          64104 sfc_os.dll
-a----        15-07-2024     15:48         330584 SgrmBroker.exe
-a----        15-07-2024     15:48         417432 SgrmEnclave.dll
-a----        15-07-2024     15:48         412896 SgrmEnclave_secure.dll
-a----        15-07-2024     15:48          58224 SgrmLpac.exe
-a----        17-11-2023     23:48         145408 shacct.dll
-a----        15-07-2024     15:47          72704 shacctprofile.dll
-a----        15-07-2024     15:47         158720 SharedPCCSP.dll
-a----        15-07-2024     15:49         307200 SharedRealitySvc.dll
-a----        15-07-2024     15:46        1117696 ShareHost.dll
-a----        15-07-2024     15:49         237056 sharemediacpl.dll
-a----        15-07-2024     15:47         701968 SHCore.dll
-a----        15-07-2024     15:47         264192 shdocvw.dll
-a----        15-07-2024     15:47        7813800 shell32.dll
-a----        15-07-2024     15:47        1191216 ShellAppRuntime.exe
-a----        15-07-2024     15:46         914944 ShellCommonCommonProxyStub.dll
-a----        07-12-2019     14:39        1155584 shellstyle.dll
-a----        07-12-2019     14:39          10752 shfolder.dll
-a----        07-12-2019     14:38          29184 shgina.dll
-a----        07-12-2019     14:39          16740 ShiftJIS.uce
-a----        17-11-2023     23:48           7680 shimeng.dll
-a----        15-07-2024     15:47          34304 shimgvw.dll
-a----        15-07-2024     15:47         343496 shlwapi.dll
-a----        07-12-2019     14:38          21504 shpafact.dll
-a----        07-12-2019     14:39          60928 shrpubw.exe
-a----        15-07-2024     15:47         140800 shsetup.dll
-a----        15-07-2024     15:48         283648 shsvcs.dll
-a----        07-12-2019     14:39          24064 shunimpl.dll
-a----        07-12-2019     14:38          28160 shutdown.exe
-a----        07-12-2019     14:38          32256 shutdownext.dll
-a----        15-07-2024     15:47         322048 shutdownux.dll
-a----        15-07-2024     15:47         463872 shwebsvc.dll
-a----        17-11-2023     23:49          55296 signdrv.dll
-a----        07-12-2019     14:39          79360 sigverif.exe
-a----        15-07-2024     15:49         409792 SIHClient.exe
-a----        15-07-2024     15:47         111104 sihost.exe
-a----        07-12-2019     14:38         160256 SimAuth.dll
-a----        07-12-2019     14:38         105472 SimCfg.dll
-a----        07-12-2019     14:39           8192 simpdata.tlb
-a----        15-07-2024     15:48         309720 skci.dll
-a----        17-11-2023     23:48         146944 slc.dll
-a----        17-11-2023     23:48          22528 slcext.dll
-a----        07-12-2019     14:38          20352 SlideToShutDown.exe
-a----        07-12-2019     14:38         142904 slmgr.vbs
-a----        15-07-2024     15:47         581120 slui.exe
-a----        07-12-2019     14:38          83456 slwga.dll
-a----        07-12-2019     14:38          69788 SmallRoom.bin
-a----        15-07-2024     15:47          69632 SmartCardBackgroundPolicy.dll
-a----        15-07-2024     15:47         820736 SmartcardCredentialProvider.dll
-a----        15-07-2024     15:47         690688 SmartCardSimulator.dll
-a----        15-07-2024     15:46        2385408 smartscreen.exe
-a----        15-07-2024     15:46         313344 smartscreenps.dll
-a----        29-10-2023     08:36         116736 SMBHelperClass.dll
-a----        15-07-2024     15:47         309760 smbwmiv2.dll
-a----        17-11-2023     23:49         878048 SmiEngine.dll
-a----        17-11-2023     23:49          37232 smphost.dll
-a----        15-07-2024     15:48         643072 SmsRouterSvc.dll
-a----        17-11-2023     23:48         157152 smss.exe
-a----        15-07-2024     15:47         276920 SndVol.exe
-a----        15-07-2024     15:47         308224 SndVolSSO.dll
-a----        15-07-2024     15:48        3371520 SnippingTool.exe
-a----        07-12-2019     14:39          33792 snmpapi.dll
-a----        07-12-2019     14:38          16896 snmptrap.exe
-a----        07-12-2019     14:38            925 Snooze_80.contrast-black.png
-a----        07-12-2019     14:38            901 Snooze_80.contrast-white.png
-a----        07-12-2019     14:38            925 Snooze_80.png
-a----        17-11-2023     23:48         145920 socialapis.dll
-a----        07-12-2019     14:39         172544 softkbd.dll
-a----        07-12-2019     14:38          10752 softpub.dll
-a----        07-12-2019     14:39          28672 sort.exe
-a----        07-12-2019     14:38          46592 SortServer2003Compat.dll
-a----        07-12-2019     14:38          50176 SortWindows61.dll
-a----        17-11-2023     23:48          74544 SortWindows62.dll
-a----        17-11-2023     23:48          74456 SortWindows64.dll
-a----        07-12-2019     14:38          70144 SortWindows6Compat.dll
-a----        15-07-2024     15:49         165888 SpaceAgent.exe
-a----        17-11-2023     23:49         180736 spacebridge.dll
-a----        15-07-2024     15:49         772608 SpaceControl.dll
-a----        15-07-2024     15:48          80880 spaceman.exe
-a----        15-07-2024     15:46         152576 SpatialAudioLicenseSrv.exe
-a----        15-07-2024     15:46         225280 SpatializerApo.dll
-a----        15-07-2024     15:49         161280 SpatialStore.dll
-a----        17-11-2023     23:48         111104 spbcd.dll
-a----        07-12-2019     14:38           1520 SpeakersSystemToastIcon.contrast-white.png
-a----        07-12-2019     14:38            897 SpeakersSystemToastIcon.png
-a----        15-07-2024     15:49         879104 Spectrum.exe
-a----        15-07-2024     15:49          40960 SpectrumSyncClient.dll
-a----        15-07-2024     15:46        1580544 SpeechPal.dll
-a----        15-07-2024     15:47         113152 spfileq.dll
-a----        17-11-2023     23:49          95744 spinf.dll
-a----        07-12-2019     14:39          11264 spmpm.dll
-a----        07-12-2019     14:39          11776 spnet.dll
-a----        15-07-2024     15:46         123904 spoolss.dll
-a----        15-07-2024     15:46         837632 spoolsv.exe
-a----        15-07-2024     15:47         102400 spopk.dll
-a----        17-11-2023     23:49         287744 spp.dll
-a----        17-11-2023     23:48         130048 sppc.dll
-a----        15-07-2024     15:47         608768 sppcext.dll
-a----        15-07-2024     15:47         316416 sppcomapi.dll
-a----        07-12-2019     14:39         319488 sppcommdlg.dll
-a----        15-07-2024     15:47         572928 SppExtComObj.Exe
-a----        07-12-2019     14:39          44344 sppinst.dll
-a----        17-11-2023     23:49         275968 sppnp.dll
-a----        15-07-2024     15:47        1787208 sppobjs.dll
-a----        15-07-2024     15:47        4630408 sppsvc.exe
-a----        15-07-2024     15:47         363112 sppwinob.dll
-a----        07-12-2019     14:38         150528 sppwmi.dll
-a----        07-12-2019     14:39          15360 spwinsat.dll
-a----        17-11-2023     23:49         530928 spwizeng.dll
-a----        07-12-2019     14:39        5865488 spwizimg.dll
-a----        17-11-2023     23:49          17776 spwizres.dll
-a----        17-11-2023     23:50          11264 spwmp.dll
-a----        15-07-2024     15:48         762880 sqlsrv32.dll
-a----        07-12-2019     14:39          94208 sqlsrv32.rll
-a----        15-07-2024     15:47          49616 sqmapi.dll
-a----        15-07-2024     15:47         218112 srchadmin.dll
-a----        15-07-2024     15:49          74752 srclient.dll
-a----        15-07-2024     15:49         529408 srcore.dll
-a----        07-12-2019     14:39          19456 srdelayed.exe
-a----        07-12-2019     14:39           5120 SrEvents.dll
-a----        15-07-2024     15:47        3852288 SRH.dll
-a----        17-11-2023     23:49          96768 srhelper.dll
-a----        07-12-2019     14:39          11292 srms-apr-v.dat
-a----        07-12-2019     14:39          19485 srms-apr.dat
-a----        07-12-2019     14:39          59554 srms.dat
-a----        15-07-2024     15:47         157696 srpapi.dll
-a----        17-11-2023     23:49         252416 srrstr.dll
-a----        17-11-2023     23:49          59392 SrTasks.exe
-a----        17-11-2023     23:49          65024 srumapi.dll
-a----        17-11-2023     23:49         243200 srumsvc.dll
-a----        17-11-2023     23:48         118984 srvcli.dll
-a----        15-07-2024     15:47         305152 srvsvc.dll
-a----        07-12-2019     14:39          27648 srwmi.dll
-a----        17-11-2023     23:48          48128 sscore.dll
-a----        07-12-2019     14:38          13312 sscoreext.dll
-a----        15-07-2024     15:46         455168 ssdm.dll
-a----        17-11-2023     23:49          67584 ssdpapi.dll
-a----        15-07-2024     15:48         270336 ssdpsrv.dll
-a----        15-07-2024     15:47         189216 sspicli.dll
-a----        15-07-2024     15:47          29184 sspisrv.dll
-a----        07-12-2019     14:39         130064 SSShim.dll
-a----        15-07-2024     15:48         224768 ssText3d.scr
-a----        17-11-2023     23:49         211968 sstpsvc.dll
-a----        15-07-2024     15:46        5806160 StartTileData.dll
-a----        07-12-2019     14:38          25088 Startupscan.dll
-a----        17-11-2023     23:48         726792 StateRepository.Core.dll
-a----        17-11-2023     23:48          67072 stclient.dll
-a----        07-12-2019     14:38          18432 stdole2.tlb
-a----        07-12-2019     14:39           7168 stdole32.tlb
-a----        15-07-2024     15:48         332800 sti.dll
-a----        15-07-2024     15:48         234496 sti_ci.dll
-a----        15-07-2024     15:46         313344 stobject.dll
-a----        15-07-2024     15:48         103936 StorageContextHandler.dll
-a----        15-07-2024     15:48         161792 StorageUsage.dll
-a----        15-07-2024     15:48        2754048 storagewmi.dll
-a----        07-12-2019     14:39          26624 storagewmi_passthru.dll
-a----        07-12-2019     14:39         111616 stordiag.exe
-a----        15-07-2024     15:47         316416 storewuauth.dll
-a----        07-12-2019     14:39          73216 Storprop.dll
-a----        15-07-2024     15:48        1072128 StorSvc.dll
-a----        07-12-2019     14:38          27448 streamci.dll
-a----        15-07-2024     15:48         187904 StringFeedbackEngine.dll
-a----        15-07-2024     15:47         677288 StructuredQuery.dll
-a----        07-12-2019     14:39          93702 SubRange.uce
-a----        17-11-2023     23:49          17408 subst.exe
-a----        15-07-2024     15:48         190464 sud.dll
-a----        16-12-2021     08:02        1296045 SvBannerBackground.png
-a----        15-07-2024     15:47          57528 svchost.exe
-a----        07-12-2019     15:22         232960 svf.dll
-a----        07-12-2019     14:39          14336 svsvc.dll
-a----        15-07-2024     15:47         195072 SwitcherDataModel.dll
-a----        15-07-2024     15:47         500224 swprv.dll
-a----        17-11-2023     23:49          78336 sxproxy.dll
-a----        17-11-2023     23:48         662792 sxs.dll
-a----        07-12-2019     14:39          46080 sxshared.dll
-a----        17-11-2023     23:48          36864 sxssrv.dll
-a----        07-12-2019     14:39          30208 sxsstore.dll
-a----        17-11-2023     23:48          37376 sxstrace.exe
-a----        15-07-2024     15:48         521216 SyncCenter.dll
-a----        15-07-2024     15:49         616960 SyncController.dll
-a----        17-11-2023     23:49          47104 SyncHost.exe
-a----        07-12-2019     14:39          14336 SyncHostps.dll
-a----        15-07-2024     15:48         425984 SyncInfrastructure.dll
-a----        07-12-2019     14:39          37376 SyncInfrastructureps.dll
-a----        15-07-2024     15:49          64000 SyncProxy.dll
-a----        07-12-2019     14:39          81408 Syncreg.dll
-a----        06-12-2019     22:03           2560 SyncRes.dll
-a----        15-07-2024     15:46         380928 SyncSettings.dll
-a----        15-07-2024     15:49         388608 syncutil.dll
-a----        07-12-2019     14:39         125440 sysclass.dll
-a----        15-07-2024     15:47         148480 sysdm.cpl
-a----        15-07-2024     15:46         378880 SysFxUI.dll
-a----        15-07-2024     15:49        1005056 sysmain.dll
-a----        15-07-2024     15:48         423936 sysmon.ocx
-a----        07-12-2019     14:38          25600 sysntfy.dll
-a----        07-12-2019     14:39           3317 sysprint.sep
-a----        07-12-2019     14:39           3666 sysprtj.sep
-a----        17-11-2023     23:49          44008 SysResetErr.exe
-a----        07-12-2019     14:39          19456 syssetup.dll
-a----        15-07-2024     15:47         138752 systemcpl.dll
-a----        17-11-2023     23:48          30208 SystemEventsBrokerClient.dll
-a----        17-11-2023     23:48         251904 SystemEventsBrokerServer.dll
-a----        07-12-2019     14:39         110080 systeminfo.exe
-a----        07-12-2019     14:39          83968 SystemPropertiesAdvanced.exe
-a----        07-12-2019     14:39          83968 SystemPropertiesComputerName.exe
-a----        07-12-2019     14:39          83968 SystemPropertiesDataExecutionPrevention.exe
-a----        07-12-2019     14:39          83968 SystemPropertiesHardware.exe
-a----        07-12-2019     14:39          84480 SystemPropertiesPerformance.exe
-a----        07-12-2019     14:39          83968 SystemPropertiesProtection.exe
-a----        07-12-2019     14:39          83968 SystemPropertiesRemote.exe
-a----        15-07-2024     15:48         522264 systemreset.exe
-a----        15-07-2024     15:46         461184 SystemSettings.DataModel.dll
-a----        15-07-2024     15:49         183296 SystemSettings.DeviceEncryptionHandlers.dll
-a----        15-07-2024     15:47        1381376 SystemSettings.Handlers.dll
-a----        15-07-2024     15:47         166280 SystemSettings.SettingsExtensibility.dll
-a----        15-07-2024     15:47         519168 SystemSettings.UserAccountsHandlers.dll
-a----        15-07-2024     15:47         521280 SystemSettingsAdminFlows.exe
-a----        15-07-2024     15:46         206240 SystemSettingsBroker.exe
-a----        15-07-2024     15:48          43040 SystemSettingsRemoveDevice.exe
-a----        15-07-2024     15:47        4009984 SystemSettingsThresholdAdminFlowUI.dll
-a----        15-07-2024     15:46          56832 SystemSupportInfo.dll
-a----        15-07-2024     15:46          86016 SystemUWPLauncher.exe
-a----        07-12-2019     14:38          11776 systray.exe
-a----        15-07-2024     15:47         181760 t2embed.dll
-a----        07-12-2019     14:39         167936 Tabbtn.dll
-a----        17-11-2023     23:49          77824 TabbtnEx.dll
-a----        07-12-2019     14:39          86016 tabcal.exe
-a----        07-12-2019     14:39         712192 TabletPC.cpl
-a----        15-07-2024     15:47         233984 TabSvc.dll
-a----        07-12-2019     14:39          66560 takeown.exe
-a----        17-11-2023     23:49         997888 tapi3.dll
-a----        17-11-2023     23:49         247808 tapi32.dll
-a----        17-11-2023     23:49          34304 tapilua.dll
-a----        17-11-2023     23:49          66048 TapiMigPlugin.dll
-a----        07-12-2019     14:39          12288 tapiperf.dll
-a----        15-07-2024     15:48         317952 tapisrv.dll
-a----        07-12-2019     14:39          13312 TapiSysprep.dll
-a----        07-12-2019     14:39           2560 tapiui.dll
-a----        07-12-2019     14:39          15360 TapiUnattend.exe
-a----        17-11-2023     23:49          54784 tar.exe
-a----        15-07-2024     15:47         414720 TaskApis.dll
-a----        15-07-2024     15:46        1094656 taskbarcpl.dll
-a----        17-11-2023     23:49         420864 taskcomp.dll
-a----        15-07-2024     15:46        1543168 TaskFlowDataEngine.dll
-a----        15-07-2024     15:47          98296 taskhostw.exe
-a----        07-12-2019     14:39         101376 taskkill.exe
-a----        07-12-2019     14:39         106496 tasklist.exe
-a----        15-07-2024     15:47        1214400 Taskmgr.exe
-a----        17-11-2023     23:49         708720 taskschd.dll
-a----        07-12-2019     14:39         145059 taskschd.msc
-a----        17-11-2023     23:49          59392 TaskSchdPS.dll
-a----        15-07-2024     15:46          76288 tbauth.dll
-a----        15-07-2024     15:46          97208 tbs.dll
-a----        15-07-2024     15:48         820792 tcblaunch.exe
-a----        15-07-2024     15:48         225248 tcbloader.dll
-a----        07-12-2019     14:39          16896 tcmsetup.exe
-a----        07-12-2019     14:39           1673 tcpbidi.xml
-a----        17-11-2023     23:49         242688 tcpipcfg.dll
-a----        17-11-2023     23:49          38912 tcpmib.dll
-a----        15-07-2024     15:47         242688 tcpmon.dll
-a----        07-12-2019     14:39          60124 tcpmon.ini
-a----        17-11-2023     23:49          74752 tcpmonui.dll
-a----        07-12-2019     14:39          12800 TCPSVCS.EXE
-a----        17-11-2023     23:49          87552 tdc.ocx
-a----        17-11-2023     23:48        1128448 tdh.dll
-a----        15-07-2024     15:47         299520 TDLMigration.dll
-a----        30-11-2020     03:28         321416 TEEManagement64.dll
-a----        07-12-2019     14:39         109056 telephon.cpl
-a----        15-07-2024     15:46         145408 TelephonyInteractiveUser.dll
-a----        07-12-2019     14:38           2560 TelephonyInteractiveUserRes.dll
-a----        17-11-2023     23:48          74752 TempSignedLicenseExchangeTask.dll
-a----        17-11-2023     23:49         436224 termmgr.dll
-a----        15-07-2024     15:48        1264128 termsrv.dll
-a----        15-07-2024     15:46          77312 tetheringclient.dll
-a----        15-07-2024     15:46          53760 tetheringconfigsp.dll
-a----        07-12-2019     14:38          15360 TetheringIeProvider.dll
-a----        17-11-2023     23:47         227840 TetheringMgr.dll
-a----        15-07-2024     15:46         263168 tetheringservice.dll
-a----        15-07-2024     15:46         208896 TetheringStation.dll
-a----        15-07-2024     15:47        1015088 TextInputFramework.dll
-a----        15-07-2024     15:47        2261504 TextInputMethodFormatter.dll
-a----        15-07-2024     15:47         708112 TextShaping.dll
-a----        15-07-2024     15:48         420864 themecpl.dll
-a----        15-07-2024     15:46         142336 Themes.SsfDownload.ScheduledTask.dll
-a----        15-07-2024     15:47          70656 themeservice.dll
-a----        15-07-2024     15:47         487424 themeui.dll
-a----        08-04-2021     21:37           1370 ThirdPartyNoticesBySHS.txt
-a----        17-11-2023     23:48          67584 threadpoolwinrt.dll
-a----        15-07-2024     15:46         403432 thumbcache.dll
-a----        17-11-2023     23:48          34304 ThumbnailExtractionHost.exe
-a----        17-11-2023     23:48           2560 tier2punctuations.dll
-a----        07-12-2019     14:39          20480 TieringEngineProxy.dll
-a----        17-11-2023     23:49         326144 TieringEngineService.exe
-a----        15-07-2024     15:47         606720 TileDataRepository.dll
-a----        17-11-2023     23:48          35328 TimeBrokerClient.dll
-a----        17-11-2023     23:48         179712 TimeBrokerServer.dll
-a----        15-07-2024     15:46         243200 timedate.cpl
-a----        07-12-2019     14:38          11776 TimeDateMUICallback.dll
-a----        07-12-2019     14:39          32768 timeout.exe
-a----        15-07-2024     15:47          47616 timesync.dll
-a----        07-12-2019     14:38          15360 TimeSyncTask.dll
-a----        15-07-2024     15:48          47104 tlscsp.dll
-a----        17-11-2023     23:48          57856 tokenbinding.dll
-a----        15-07-2024     15:46        1531392 TokenBroker.dll
-a----        15-07-2024     15:46          48128 TokenBrokerCookies.exe
-a----        15-07-2024     15:47          78336 TokenBrokerUI.dll
-a----        07-12-2019     14:38         144862 tpm.msc
-a----        15-07-2024     15:46           3584 TpmCertResources.dll
-a----        07-12-2019     14:38          45056 tpmcompc.dll
-a----        15-07-2024     15:46        1173504 TpmCoreProvisioning.dll
-a----        07-12-2019     14:38          73728 TpmInit.exe
-a----        15-07-2024     15:46         467456 TpmTasks.dll
-a----        15-07-2024     15:46         273920 TpmTool.exe
-a----        15-07-2024     15:49         319488 tpmvsc.dll
-a----        15-07-2024     15:47         102400 tpmvscmgr.exe
-a----        15-07-2024     15:47         143872 tpmvscmgrsvr.exe
-a----        15-07-2024     15:47        3308032 tquery.dll
-a----        17-11-2023     23:49         429056 tracerpt.exe
-a----        07-12-2019     14:39          18432 TRACERT.EXE
-a----        07-12-2019     14:39          45056 traffic.dll
-a----        07-12-2019     14:38          10576 TransformPPSToWlan.xslt
-a----        07-12-2019     14:38           1688 TransformPPSToWlanCredentials.xslt
-a----        15-07-2024     15:46          62976 TransliterationRanker.dll
-a----        17-11-2023     23:49          20992 tree.com
-a----        15-07-2024     15:46         177664 trie.dll
-a----        17-11-2023     23:48         115200 trkwks.dll
-a----        15-07-2024     15:47         115712 TrustedSignalCredProv.dll
-a----        07-12-2019     14:39          16896 tsbyuv.dll
-a----        15-07-2024     15:47        1362432 tsf3gip.dll
-a----        15-07-2024     15:48          71168 tsgqec.dll
-a----        17-11-2023     23:49         415832 tsmf.dll
-a----        15-07-2024     15:47         153088 TSpkg.dll
-a----        15-07-2024     15:49          88576 TSSessionUX.dll
-a----        17-11-2023     23:49          69120 TSTheme.exe
-a----        17-11-2023     23:47          41472 TsUsbGDCoInstaller.dll
-a----        07-12-2019     14:38          13824 TsUsbRedirectionGroupPolicyExtension.dll
-a----        17-11-2023     23:49          78336 TSWbPrxy.exe
-a----        15-07-2024     15:47        1229824 TSWorkspace.dll
-a----        15-07-2024     15:47         283688 ttdinject.exe
-a----        07-12-2019     14:38          15512 ttdloader.dll
-a----        07-12-2019     14:38          67112 ttdplm.dll
-a----        15-07-2024     15:47         648752 ttdrecord.dll
-a----        07-12-2019     14:38        1597008 ttdrecordcpu.dll
-a----        15-07-2024     15:46         291840 TtlsAuth.dll
-a----        07-12-2019     14:38         224256 TtlsCfg.dll
-a----        17-11-2023     23:48         207360 TtlsExt.dll
-a----        15-07-2024     15:47          86896 tttracer.exe
-a----        17-11-2023     23:49          36864 tvratings.dll
-a----        15-07-2024     15:47         186880 twext.dll
-a----        15-07-2024     15:46        2110064 twinapi.appcore.dll
-a----        15-07-2024     15:47         669184 twinapi.dll
-a----        15-07-2024     15:46         659968 twinui.appcore.dll
-a----        15-07-2024     15:47        6331392 twinui.dll
-a----        15-07-2024     15:47        6939136 twinui.pcshell.dll
-a----        07-12-2019     14:38         119296 txflog.dll
-a----        07-12-2019     14:38          12800 txfw32.dll
-a----        17-11-2023     23:49          49664 typeperf.exe
-a----        15-07-2024     15:46         175616 tzautoupdate.dll
-a----        15-07-2024     15:47           2560 tzres.dll
-a----        07-12-2019     14:39          70144 tzsync.exe
-a----        07-12-2019     14:39           4096 tzsyncres.dll
-a----        07-12-2019     14:38          59904 tzutil.exe
-a----        17-11-2023     23:49         280576 ubpm.dll
-a----        17-11-2023     23:49          65024 ucmhc.dll
-a----        15-07-2024     15:46          62976 UCPDMgr.exe
-a----        17-11-2023     23:48        1046080 ucrtbase.dll
-a----        25-06-2022     03:01         826792 ucrtbase_clr0400.dll
-a----        17-11-2023     23:49         502160 ucrtbase_enclave.dll
-a----        07-12-2019     14:38          56632 ucsvc.exe
-a----        17-11-2023     23:49          70656 udhisapi.dll
-a----        15-07-2024     15:47        1009152 uDWM.dll
-a----        07-12-2019     14:38          39936 UefiCsp.dll
-a----        17-11-2023     23:48         111104 uexfat.dll
-a----        17-11-2023     23:48         152064 ufat.dll
-a----        15-07-2024     15:46         637952 UiaManager.dll
-a----        17-11-2023     23:48         269824 UIAnimation.dll
-a----        15-07-2024     15:46        3062784 UIAutomationCore.dll
-a----        17-11-2023     23:49          44544 uicom.dll
-a----        17-11-2023     23:49          13824 UIManagerBrokerps.dll
-a----        15-07-2024     15:47          38400 UIMgrBroker.exe
-a----        15-07-2024     15:47         290816 uireng.dll
-a----        07-12-2019     14:40        4080640 UIRibbon.dll
-a----        07-12-2019     14:40         835072 UIRibbonRes.dll
-a----        17-11-2023     23:48         186848 ulib.dll
-a----        17-11-2023     23:48          79360 umb.dll
-a----        07-12-2019     14:39          19968 umdmxfrm.dll
-a----        17-11-2023     23:47          65752 umpdc.dll
-a----        17-11-2023     23:49         133120 umpnpmgr.dll
-a----        15-07-2024     15:46          62464 umpo-overrides.dll
-a----        17-11-2023     23:47         178688 umpo.dll
-a----        15-07-2024     15:47         173056 umpoext.dll
-a----        07-12-2019     14:39          91648 umpowmi.dll
-a----        17-11-2023     23:49         396800 umrdp.dll
-a----        07-12-2019     14:39         207160 unattend.dll
-a----        15-07-2024     15:47         103936 unenrollhook.dll
-a----        15-07-2024     15:48         339456 UnifiedConsent.dll
-a----        07-12-2019     14:39         302080 unimdm.tsp
-a----        07-12-2019     14:39          79872 unimdmat.dll
-a----        07-12-2019     14:39          23040 uniplat.dll
-a----        15-07-2024     15:47        1192448 Unistore.dll
-a----        07-12-2019     14:38          42496 unlodctr.exe
-a----        07-12-2019     02:58         265216 unregmp2.exe
-a----        17-11-2023     23:48         595968 untfs.dll
-a----        15-07-2024     15:47        2632576 UpdateAgent.dll
-a----        15-07-2024     15:47         119296 updatecsp.dll
-a----        15-07-2024     15:47         328704 UpdateDeploymentProvider.dll
-a----        15-07-2024     15:46         232448 updatepolicy.dll
-a----        07-12-2019     14:38         121392 upfc.exe
-a----        15-07-2024     15:47          44544 UpgradeResultsUI.exe
-a----        15-07-2024     15:48         427520 upnp.dll
-a----        17-11-2023     23:49          43008 upnpcont.exe
-a----        17-11-2023     23:49         471552 upnphost.dll
-a----        15-07-2024     15:49          52224 UPPrinterInstaller.exe
-a----        15-07-2024     15:49         108032 UPPrinterInstallsCSP.dll
-a----        15-07-2024     15:47         717680 upshared.dll
-a----        15-07-2024     15:47         803328 uReFS.dll
-a----        07-12-2019     14:38         568320 uReFSv1.dll
-a----        17-11-2023     23:49          32768 ureg.dll
-a----        07-12-2019     14:39         236032 url.dll
-a----        15-07-2024     15:47        1949184 urlmon.dll
-a----        07-12-2019     14:38          41472 UsbCApi.dll
-a----        07-12-2019     14:38         119808 usbceip.dll
-a----        15-07-2024     15:46        1180672 usbmon.dll
-a----        07-12-2019     14:38          14336 usbperf.dll
-a----        07-12-2019     14:38          49152 UsbPmApi.dll
-a----        15-07-2024     15:48          78336 UsbSettingsHandlers.dll
-a----        17-11-2023     23:47          55808 UsbTask.dll
-a----        07-12-2019     14:38          93696 usbui.dll
-a----        15-07-2024     15:47        1700984 user32.dll
-a----        15-07-2024     15:47          49632 UserAccountBroker.exe
-a----        15-07-2024     15:47         128000 UserAccountControlSettings.dll
-a----        15-07-2024     15:47         102400 UserAccountControlSettings.exe
-a----        15-07-2024     15:46         201728 useractivitybroker.dll
-a----        15-07-2024     15:47         786944 usercpl.dll
-a----        07-12-2019     14:38           8192 UserDataAccessRes.dll
-a----        15-07-2024     15:47         455680 UserDataAccountApis.dll
-a----        07-12-2019     14:38          44544 UserDataLanguageUtil.dll
-a----        17-11-2023     23:48          64512 UserDataPlatformHelperUtil.dll
-a----        15-07-2024     15:47        1554944 UserDataService.dll
-a----        15-07-2024     15:47         122880 UserDataTimeUtil.dll
-a----        07-12-2019     14:38          46592 UserDataTypeHelperUtil.dll
-a----        15-07-2024     15:46         238592 UserDeviceRegistration.dll
-a----        15-07-2024     15:46         349184 UserDeviceRegistration.Ngc.dll
-a----        15-07-2024     15:47         178264 userenv.dll
-a----        15-07-2024     15:47          54272 userinit.exe
-a----        17-11-2023     23:48          25088 userinitext.dll
-a----        15-07-2024     15:47          61440 UserLanguageProfileCallback.dll
-a----        15-07-2024     15:47        1486848 usermgr.dll
-a----        15-07-2024     15:47          82160 usermgrcli.dll
-a----        15-07-2024     15:47         323584 UserMgrProxy.dll
-a----        07-12-2019     14:38          31232 usk.rs
-a----        15-07-2024     15:47         141824 usoapi.dll
-a----        15-07-2024     15:47         115712 UsoClient.exe
-a----        17-11-2023     23:48          39424 usocoreps.dll
-a----        15-07-2024     15:47        1414144 usocoreworker.exe
-a----        15-07-2024     15:47         570368 usosvc.dll
-a----        17-11-2023     23:48          79360 usp10.dll
-a----        07-12-2019     14:38          51712 ustprov.dll
-a----        15-07-2024     15:46         145920 UtcDecoderHost.exe
-a----        15-07-2024     15:47         105984 utcutil.dll
-a----        07-12-2019     14:38          48056 utildll.dll
-a----        15-07-2024     15:47         126464 Utilman.exe
-a----        17-11-2023     23:48         173056 uudf.dll
-a----        15-07-2024     15:47         139264 UvcModel.dll
-a----        15-07-2024     15:47         120320 UXInit.dll
-a----        17-11-2023     23:49         182144 uxlib.dll
-a----        07-12-2019     14:39          11576 uxlibres.dll
-a----        15-07-2024     15:47         627200 uxtheme.dll
-a----        15-07-2024     15:46         384920 vac.dll
-a----        15-07-2024     15:48         339968 VAN.dll
-a----        15-07-2024     15:48         366592 Vault.dll
-a----        15-07-2024     15:46         149504 VaultCDS.dll
-a----        15-07-2024     15:46         321536 vaultcli.dll
-a----        07-12-2019     14:38          30720 VaultCmd.exe
-a----        15-07-2024     15:46         119808 VaultRoaming.dll
-a----        15-07-2024     15:46         370688 vaultsvc.dll
-a----        17-11-2023     23:49         170496 VBICodec.ax
-a----        07-12-2019     14:39          47616 vbisurf.ax
-a----        15-07-2024     15:48         156160 vbsapi.dll
-a----        15-07-2024     15:47         618496 vbscript.dll
-a----        15-07-2024     15:49          85504 vbssysprep.dll
-a----        19-01-2024     20:38         412752 vcamp140.dll
-a----        17-11-2023     23:48         188416 VCardParser.dll
-a----        01-02-2002     19:02         348784 vccorlib140.dll
-a----        19-01-2024     20:38         196688 vcomp140.dll
-a----        01-02-2002     19:02         119376 vcruntime140.dll
-a----        01-02-2002     19:02          49744 vcruntime140_1.dll
-a----        25-06-2022     03:01          37800 vcruntime140_1_clr0400.dll
-a----        25-06-2022     03:01          98728 vcruntime140_clr0400.dll
-a----        01-02-2002     19:02          38512 vcruntime140_threads.dll
-a----        15-07-2024     15:47         724480 vds.exe
-a----        17-11-2023     23:49         256000 vdsbas.dll
-a----        17-11-2023     23:49         603648 vdsdyn.dll
-a----        17-11-2023     23:49          27136 vdsldr.exe
-a----        17-11-2023     23:49         135168 vdsutil.dll
-a----        17-11-2023     23:49          60928 vdsvd.dll
-a----        17-11-2023     23:49         109056 vds_ps.dll
-a----        07-12-2019     14:39          13824 verclsid.exe
-a----        07-12-2019     14:39         395584 verifier.dll
-a----        07-12-2019     14:38         177976 verifier.exe
-a----        07-12-2019     14:38         203264 verifiergui.exe
-a----        17-11-2023     23:48          32584 version.dll
-a----        17-11-2023     23:49         173272 vertdll.dll
-a----        15-07-2024     15:49          38912 vfpapi.dll
-a----        15-07-2024     15:49         320000 vfpctrl.exe
-a----        15-07-2024     15:46         147456 vfuprov.dll
-a----        07-12-2019     14:39          70656 vfwwdm32.dll
-a----        07-12-2019     14:38          37376 VhfUm.dll
-a----        17-11-2023     23:49          96744 vid.dll
-a----        07-12-2019     14:39          34304 vidcap.ax
-a----        15-07-2024     15:47         223232 VideoHandlers.dll
-a----        17-11-2023     23:50         115312 VIDRESZR.DLL
-a----        17-11-2023     23:48          70120 virtdisk.dll
-a----        15-07-2024     15:49          96256 VirtualMonitorManager.dll
-a----        07-12-2019     14:39          26128 VmApplicationHealthMonitorProxy.dll
-a----        15-07-2024     15:46          30536 vmbuspipe.dll
-a----        15-07-2024     15:46          27104 vmbuspiper.dll
-a----        15-07-2024     15:49         213488 vmbusvdev.dll
-a----        08-04-2021     19:23           6658 VmChipset Third-Party Notices.txt
-a----        15-07-2024     15:49        6558704 vmchipset.dll
-a----        15-07-2024     15:49         678896 vmcompute.dll
-a----        15-07-2024     15:49        3225584 vmcompute.exe
-a----        29-07-2024     11:23          31544 vmcomputeeventlog.dll
-a----        15-07-2024     15:49         262528 VmCrashDump.dll
-a----        15-07-2024     15:48         221184 vmdevicehost.dll
-a----        15-07-2024     15:49         293760 vmdynmem.dll
-a----        15-07-2024     15:49         250224 vmflexio.dll
-a----        15-07-2024     15:49         318448 vmiccore.dll
-a----        15-07-2024     15:49          63856 vmictimeprovider.dll
-a----        15-07-2024     15:49         547712 vmpmem.dll
-a----        15-07-2024     15:49         411120 vmprox.dll
-a----        15-07-2024     15:49         487424 vmrdvcore.dll
-a----        15-07-2024     15:49         531328 vmserial.dll
-a----        15-07-2024     15:49         287728 vmsif.dll
-a----        15-07-2024     15:49         123880 vmsifcore.dll
-a----        17-11-2023     23:49          29160 vmsifproxystub.dll
-a----        15-07-2024     15:49         382952 vmsmb.dll
-a----        15-07-2024     15:49         408544 VmSynthNic.dll
-a----        15-07-2024     15:49         404352 vmsynthstor.dll
-a----        15-07-2024     15:49         661472 vmuidevices.dll
-a----        15-07-2024     15:49         508784 vmusrv.dll
-a----        15-07-2024     15:49         131952 vmvirtio.dll
-a----        15-07-2024     15:49         408064 vmvpci.dll
-a----        15-07-2024     15:49        2403408 vmwp.exe
-a----        15-07-2024     15:49          80368 vmwpctrl.dll
-a----        17-11-2023     23:49         110560 vmwpevents.dll
-a----        15-07-2024     15:46         132608 VocabRoamingHandler.dll
-a----        15-07-2024     15:47          93184 VoiceActivationManager.dll
-a----        15-07-2024     15:46         151552 VoipRT.dll
-a----        15-07-2024     15:49         397192 vp9fs.dll
-a----        15-07-2024     15:47         736256 vpnike.dll
-a----        07-12-2019     14:39          54784 vpnikeapi.dll
-a----        07-12-2019     14:39          11264 VpnSohDesktop.dll
-a----        17-11-2023     23:48         265728 VPNv2CSP.dll
-a----        15-07-2024     15:49          69488 VrdUmed.dll
-a----        07-12-2019     14:40          20480 VscMgrPS.dll
-a----        07-12-2019     14:39         145920 vssadmin.exe
-a----        15-07-2024     15:47        1674240 vssapi.dll
-a----        17-11-2023     23:48          70656 vsstrace.dll
-a----        15-07-2024     15:47        1495040 VSSVC.exe
-a----        17-11-2023     23:48          61952 vss_ps.dll
-a----        02-08-2021     19:21        1115664 vulkan-1-999-0-0-0.dll
-a----        02-08-2021     19:21        1115664 vulkan-1.dll
-a----        02-08-2021     19:21        1870368 vulkaninfo-1-999-0-0-0.exe
-a----        02-08-2021     19:21        1870368 vulkaninfo.exe
-a----        15-07-2024     15:46         529920 w32time.dll
-a----        07-12-2019     14:38         108032 w32tm.exe
-a----        17-11-2023     23:48          36352 w32topl.dll
-a----        15-07-2024     15:47         154624 WaaSAssessment.dll
-a----        15-07-2024     15:47         112640 WaaSMedicAgent.exe
-a----        15-07-2024     15:47         369152 WaaSMedicCapsule.dll
-a----        15-07-2024     15:47          29184 WaaSMedicPS.dll
-a----        15-07-2024     15:47         427520 WaaSMedicSvc.dll
-a----        07-12-2019     14:39          70144 WABSyncProvider.dll
-a----        07-12-2019     14:39          42496 waitfor.exe
-a----        07-12-2019     14:38          12800 WalletBackgroundServiceProxy.dll
-a----        07-12-2019     14:38         104960 WalletProxy.dll
-a----        15-07-2024     15:49         442368 WalletService.dll
-a----        15-07-2024     15:47          23552 WallpaperHost.exe
-a----        17-11-2023     23:49         265216 wavemsp.dll
-a----        17-11-2023     23:50         329728 wbadmin.exe
-a----        15-07-2024     15:46         561664 wbemcomn.dll
-a----        15-07-2024     15:49        1623552 wbengine.exe
-a----        15-07-2024     15:47         886272 wbiosrvc.dll
-a----        17-11-2023     23:48          26112 wci.dll
-a----        15-07-2024     15:47         137728 wcimage.dll
-a----        15-07-2024     15:46         156160 wcmapi.dll
-a----        15-07-2024     15:46         246272 wcmcsp.dll
-a----        15-07-2024     15:46         986112 wcmsvc.dll
-a----        17-11-2023     23:47         140288 WcnApi.dll
-a----        17-11-2023     23:47         483840 wcncsvc.dll
-a----        07-12-2019     14:38          39936 WcnEapAuthProxy.dll
-a----        07-12-2019     14:38          37376 WcnEapPeerProxy.dll
-a----        17-11-2023     23:47          49664 WcnNetsh.dll
-a----        15-07-2024     15:46         346624 wcnwiz.dll
-a----        15-07-2024     15:47         297984 wc_storage.dll
-a----        07-12-2019     14:39         739840 wdc.dll
-a----        07-12-2019     14:38         105472 wdi.dll
-a----        15-07-2024     15:47         276992 wdigest.dll
-a----        15-07-2024     15:46         260608 wdmaud.drv
-a----        17-11-2023     23:49         260064 wdscore.dll
-a----        07-12-2019     14:38            614 WdsUnattendTemplate.xml
-a----        07-12-2019     14:38           4608 WEB.rs
-a----        15-07-2024     15:47         527872 webauthn.dll
-a----        15-07-2024     15:49         992768 WebcamUi.dll
-a----        15-07-2024     15:48         270336 webcheck.dll
-a----        15-07-2024     15:49         236544 WebClnt.dll
-a----        17-11-2023     23:48         595456 webio.dll
-a----        15-07-2024     15:48        1234944 webplatstorageserver.dll
-a----        15-07-2024     15:47        2573824 WebRuntimeManager.dll
-a----        15-07-2024     15:47        1395080 webservices.dll
-a----        17-11-2023     23:48          47104 Websocket.dll
-a----        23-02-2024     23:41          81408 wecapi.dll
-a----        15-07-2024     15:48         245248 wecsvc.dll
-a----        23-02-2024     23:41         107008 wecutil.exe
-a----        07-12-2019     14:39          28672 wephostsvc.dll
-a----        15-07-2024     15:47         891600 wer.dll
-a----        15-07-2024     15:48         893952 werconcpl.dll
-a----        15-07-2024     15:48         132608 wercplsupport.dll
-a----        23-02-2024     23:40          47104 werdiagcontroller.dll
-a----        23-02-2024     23:40          25384 WerEnc.dll
-a----        15-07-2024     15:47         255136 weretw.dll
-a----        15-07-2024     15:47         577920 WerFault.exe
-a----        15-07-2024     15:47         180336 WerFaultSecure.exe
-a----        15-07-2024     15:47         237424 wermgr.exe
-a----        15-07-2024     15:47         254464 wersvc.dll
-a----        15-07-2024     15:48         256000 werui.dll
-a----        15-07-2024     15:47         405088 wevtapi.dll
-a----        15-07-2024     15:48         137216 wevtfwd.dll
-a----        15-07-2024     15:47        1882624 wevtsvc.dll
-a----        17-11-2023     23:48         248320 wevtutil.exe
-a----        07-12-2019     14:39         146944 wextract.exe
-a----        07-12-2019     14:38         115109 WF.msc
-a----        15-07-2024     15:47          25088 wfapigp.dll
-a----        17-11-2023     23:47          41472 wfdprov.dll
-a----        07-12-2019     14:38          72704 WFDSConMgr.dll
-a----        15-07-2024     15:46         677888 WFDSConMgrSvc.dll
-a----        17-11-2023     23:49          90624 WfHC.dll
-a----        15-07-2024     15:49         966656 WFS.exe
-a----        17-11-2023     23:50         669696 WFSR.dll
-a----        07-12-2019     14:38          61752 whealogr.dll
-a----        07-12-2019     14:39          43008 where.exe
-a----        07-12-2019     14:39          17920 whhelper.dll
-a----        07-12-2019     14:39          73728 whoami.exe
-a----        17-11-2023     23:49          98816 wiaacmgr.exe
-a----        15-07-2024     15:48         813056 wiaaut.dll
-a----        15-07-2024     15:48         253952 wiadefui.dll
-a----        15-07-2024     15:48         173056 wiadss.dll
-a----        07-12-2019     14:39          11776 WiaExtensionHost64.dll
-a----        15-07-2024     15:48         118272 wiarpc.dll
-a----        17-11-2023     23:49         102912 wiascanprofiles.dll
-a----        15-07-2024     15:48         782336 wiaservc.dll
-a----        17-11-2023     23:49          90624 wiashext.dll
-a----        15-07-2024     15:48          18944 wiatrace.dll
-a----        07-12-2019     14:39          38912 wiawow64.exe
-a----        15-07-2024     15:46         284160 WiFiCloudStore.dll
-a----        17-11-2023     23:47          41984 WiFiConfigSP.dll
-a----        15-07-2024     15:46          45568 wifidatacapabilityhandler.dll
-a----        15-07-2024     15:46         387584 WiFiDisplay.dll
-a----        15-07-2024     15:46         804864 wifinetworkmanager.dll
-a----        17-11-2023     23:47         133608 wifitask.exe
-a----        07-12-2019     14:38           2404 WimBootCompress.ini
-a----        17-11-2023     23:48         765808 wimgapi.dll
-a----        17-11-2023     23:48         523120 wimserv.exe
-a----        15-07-2024     15:47         127488 win32appinventorycsp.dll
-a----        15-07-2024     15:47         148960 Win32AppSettingsProvider.dll
-a----        15-07-2024     15:47         248320 Win32CompatibilityAppraiserCSP.dll
-a----        15-07-2024     15:47         598016 win32k.sys
-a----        15-07-2024     15:47        2864128 win32kbase.sys
-a----        15-07-2024     15:47        3793408 win32kfull.sys
-a----        15-07-2024     15:47          30208 win32kns.sys
-a----        15-07-2024     15:46        1337344 win32spl.dll
-a----        15-07-2024     15:47         133920 win32u.dll
-a----        17-11-2023     23:47          28672 Win32_DeviceGuard.dll
-a----        15-07-2024     15:47         183296 winbio.dll
-a----        15-07-2024     15:49         521728 WinBioDataModel.dll
-a----        15-07-2024     15:49          79360 WinBioDataModelOOBE.exe
-a----        15-07-2024     15:48          43520 winbioext.dll
-a----        15-07-2024     15:47         205232 winbrand.dll
-a----        15-07-2024     15:47         437248 wincorlib.dll
-a----        17-11-2023     23:49          44544 wincredprovider.dll
-a----        15-07-2024     15:47         216576 wincredui.dll
-a----        15-07-2024     15:47        1681920 WindowManagement.dll
-a----        15-07-2024     15:47         658640 WindowManagementAPI.dll
-a----        15-07-2024     15:46        1075200 Windows.AccountsControl.dll
-a----        03-12-2020     22:33        5729280 Windows.AI.MachineLearning.dll
-a----        17-11-2023     23:48         108544 Windows.AI.MachineLearning.Preview.dll
-a----        15-07-2024     15:47         122880 Windows.ApplicationModel.Background.SystemEventsBroker.dll
-a----        17-11-2023     23:48          31232 Windows.ApplicationModel.Background.TimeBroker.dll
-a----        15-07-2024     15:46         781824 Windows.ApplicationModel.ConversationalAgent.dll
-a----        29-10-2023     08:35          73216 windows.applicationmodel.conversationalagent.internal.proxystub.dll
-a----        29-10-2023     08:35          89088 windows.applicationmodel.conversationalagent.proxystub.dll
-a----        15-07-2024     15:46         223744 Windows.ApplicationModel.Core.dll
-a----        15-07-2024     15:46         802288 windows.applicationmodel.datatransfer.dll
-a----        15-07-2024     15:46         954096 Windows.ApplicationModel.dll
-a----        15-07-2024     15:47         494080 Windows.ApplicationModel.LockScreen.dll
-a----        15-07-2024     15:47        2326528 Windows.ApplicationModel.Store.dll
-a----        15-07-2024     15:47          68096 Windows.ApplicationModel.Store.Preview.DOSettings.dll
-a----        15-07-2024     15:47         322048 Windows.ApplicationModel.Store.TestingFramework.dll
-a----        15-07-2024     15:47         577024 Windows.ApplicationModel.Wallet.dll
-a----        15-07-2024     15:46        2501120 Windows.CloudStore.dll
-a----        15-07-2024     15:47         894464 Windows.CloudStore.Schema.DesktopShell.dll
-a----        15-07-2024     15:46         861696 Windows.CloudStore.Schema.Shell.dll
-a----        15-07-2024     15:47         618496 Windows.Cortana.Desktop.dll
-a----        15-07-2024     15:47         366592 Windows.Cortana.OneCore.dll
-a----        15-07-2024     15:47         135168 Windows.Cortana.ProxyStub.dll
-a----        15-07-2024     15:47         536064 Windows.Data.Activities.dll
-a----        15-07-2024     15:46        6724608 Windows.Data.Pdf.dll
-a----        15-07-2024     15:46         647680 Windows.Devices.AllJoyn.dll
-a----        15-07-2024     15:46          90112 Windows.Devices.Background.dll
-a----        07-12-2019     14:38          20992 Windows.Devices.Background.ps.dll
-a----        15-07-2024     15:46        2314752 Windows.Devices.Bluetooth.dll
-a----        15-07-2024     15:46         100864 Windows.Devices.Custom.dll
-a----        07-12-2019     14:38          23552 Windows.Devices.Custom.ps.dll
-a----        15-07-2024     15:46         540440 Windows.Devices.Enumeration.dll
-a----        15-07-2024     15:46         190976 Windows.Devices.Haptics.dll
-a----        17-11-2023     23:48         288768 Windows.Devices.HumanInterfaceDevice.dll
-a----        15-07-2024     15:47         392192 Windows.Devices.Lights.dll
-a----        17-11-2023     23:48         596992 Windows.Devices.LowLevel.dll
-a----        15-07-2024     15:46         437760 Windows.Devices.Midi.dll
-a----        15-07-2024     15:47        2339328 Windows.Devices.Perception.dll
-a----        15-07-2024     15:49         484352 Windows.Devices.Picker.dll
-a----        15-07-2024     15:47        2078208 Windows.Devices.PointOfService.dll
-a----        15-07-2024     15:47          54784 Windows.Devices.Portable.dll
-a----        17-11-2023     23:48         154112 Windows.Devices.Printers.dll
-a----        17-11-2023     23:49          45056 Windows.Devices.Printers.Extensions.dll
-a----        15-07-2024     15:46         218624 Windows.Devices.Radios.dll
-a----        15-07-2024     15:48         219648 Windows.Devices.Scanners.dll
-a----        15-07-2024     15:47        1289216 Windows.Devices.Sensors.dll
-a----        17-11-2023     23:48         155136 Windows.Devices.SerialCommunication.dll
-a----        15-07-2024     15:46         807424 Windows.Devices.SmartCards.dll
-a----        15-07-2024     15:47         567808 Windows.Devices.SmartCards.Phone.dll
-a----        17-11-2023     23:48         424448 Windows.Devices.Usb.dll
-a----        15-07-2024     15:46         301568 Windows.Devices.WiFi.dll
-a----        17-11-2023     23:47         504832 Windows.Devices.WiFiDirect.dll
-a----        15-07-2024     15:46         199680 Windows.Energy.dll
-a----        15-07-2024     15:47         373760 Windows.FileExplorer.Common.dll
-a----        15-07-2024     15:46         916992 Windows.Gaming.Input.dll
-a----        15-07-2024     15:47         389120 Windows.Gaming.Preview.dll
-a----        15-07-2024     15:47          88064 Windows.Gaming.UI.GameBar.dll
-a----        17-11-2023     23:47         463360 Windows.Gaming.XboxLive.Storage.dll
-a----        15-07-2024     15:46        1712128 Windows.Globalization.dll
-a----        17-11-2023     23:48          62976 Windows.Globalization.Fontgroups.dll
-a----        15-07-2024     15:47         777728 Windows.Globalization.PhoneNumberFormatting.dll
-a----        15-07-2024     15:47         132776 Windows.Graphics.Display.BrightnessOverride.dll
-a----        15-07-2024     15:47         372576 Windows.Graphics.Display.DisplayEnhancementOverride.dll
-a----        15-07-2024     15:46         566664 Windows.Graphics.dll
-a----        15-07-2024     15:46        2308096 Windows.Graphics.Printing.3D.dll
-a----        15-07-2024     15:46         877568 Windows.Graphics.Printing.dll
-a----        15-07-2024     15:47        1252352 Windows.Graphics.Printing.Workflow.dll
-a----        15-07-2024     15:47          19968 Windows.Graphics.Printing.Workflow.Native.dll
-a----        07-12-2019     14:39         158208 Windows.Help.Runtime.dll
-a----        15-07-2024     15:47         782848 windows.immersiveshell.serviceprovider.dll
-a----        15-07-2024     15:47         133632 Windows.Internal.AdaptiveCards.XamlCardRenderer.dll
-a----        15-07-2024     15:46         546304 Windows.Internal.Bluetooth.dll
-a----        15-07-2024     15:47         231424 Windows.Internal.CapturePicker.Desktop.dll
-a----        15-07-2024     15:47         174592 Windows.Internal.CapturePicker.dll
-a----        15-07-2024     15:46         299520 Windows.Internal.Devices.Sensors.dll
-a----        15-07-2024     15:49         137216 Windows.Internal.Feedback.Analog.dll
-a----        07-12-2019     15:22          24064 Windows.Internal.Feedback.Analog.ProxyStub.dll
-a----        15-07-2024     15:47         253440 Windows.Internal.Graphics.Display.DisplayColorManagement.dll
-a----        15-07-2024     15:47         170496 Windows.Internal.Graphics.Display.DisplayEnhancementManagement.dll
-a----        15-07-2024     15:47        1132032 Windows.Internal.Management.dll
-a----        15-07-2024     15:46          67072 Windows.Internal.PlatformExtension.DevicePickerExperience.dll
-a----        15-07-2024     15:48          56832 Windows.Internal.PlatformExtension.MiracastBannerExperience.dll
-a----        15-07-2024     15:49         516608 Windows.Internal.PredictionUnit.dll
-a----        15-07-2024     15:48         158208 Windows.Internal.Security.Attestation.DeviceAttestation.dll
-a----        17-11-2023     23:49          48640 Windows.Internal.SecurityMitigationsBroker.dll
-a----        15-07-2024     15:47         904952 Windows.Internal.Shell.Broker.dll
-a----        15-07-2024     15:46          90112 windows.internal.shellcommon.AccountsControlExperience.dll
-a----        15-07-2024     15:46          61952 windows.internal.shellcommon.AppResolverModal.dll
-a----        15-07-2024     15:46         146328 Windows.Internal.ShellCommon.Broker.dll
-a----        15-07-2024     15:47          41984 windows.internal.shellcommon.FilePickerExperienceMEM.dll
-a----        15-07-2024     15:47          41472 Windows.Internal.ShellCommon.PrintExperience.dll
-a----        15-07-2024     15:46         317440 windows.internal.shellcommon.shareexperience.dll
-a----        15-07-2024     15:46          59392 windows.internal.shellcommon.TokenBrokerModal.dll
-a----        15-07-2024     15:46        1065472 Windows.Internal.Signals.dll
-a----        15-07-2024     15:46         258048 Windows.Internal.System.UserProfile.dll
-a----        15-07-2024     15:47         188928 Windows.Internal.Taskbar.dll
-a----        07-12-2019     14:38          93696 Windows.Internal.UI.BioEnrollment.ProxyStub.dll
-a----        07-12-2019     14:38         265216 Windows.Internal.UI.Logon.ProxyStub.dll
-a----        15-07-2024     15:47         433152 Windows.Internal.UI.Shell.WindowTabManager.dll
-a----        15-07-2024     15:46          71168 Windows.Management.EnrollmentStatusTracking.ConfigProvider.dll
-a----        15-07-2024     15:46         301056 Windows.Management.InprocObjects.dll
-a----        15-07-2024     15:46         111104 Windows.Management.ModernDeployment.ConfigProviders.dll
-a----        17-11-2023     23:47          34304 Windows.Management.Provisioning.ProxyStub.dll
-a----        15-07-2024     15:46         860672 Windows.Management.Service.dll
-a----        15-07-2024     15:46         254320 Windows.Management.Workplace.dll
-a----        17-11-2023     23:48          34304 Windows.Management.Workplace.WorkplaceSettings.dll
-a----        15-07-2024     15:49        1339904 Windows.Media.Audio.dll
-a----        15-07-2024     15:46         920576 Windows.Media.BackgroundMediaPlayback.dll
-a----        17-11-2023     23:48          13824 Windows.Media.BackgroundPlayback.exe
-a----        15-07-2024     15:46         593000 Windows.Media.Devices.dll
-a----        15-07-2024     15:49        7549296 Windows.Media.dll
-a----        17-11-2023     23:50        1393152 Windows.Media.Editing.dll
-a----        17-11-2023     23:48        1404416 Windows.Media.FaceAnalysis.dll
-a----        15-07-2024     15:46         791040 Windows.Media.Import.dll
-a----        15-07-2024     15:47         561480 Windows.Media.MediaControl.dll
-a----        15-07-2024     15:49        1071616 Windows.Media.MixedRealityCapture.dll
-a----        15-07-2024     15:46        1044992 Windows.Media.Ocr.dll
-a----        15-07-2024     15:46         918528 Windows.Media.Playback.BackgroundMediaPlayer.dll
-a----        15-07-2024     15:46         897024 Windows.Media.Playback.MediaPlayer.dll
-a----        17-11-2023     23:48         113664 Windows.Media.Playback.ProxyStub.dll
-a----        15-07-2024     15:46       10348448 Windows.Media.Protection.PlayReady.dll
-a----        15-07-2024     15:49         117248 Windows.Media.Renewal.dll
-a----        15-07-2024     15:47        1885696 Windows.Media.Speech.dll
-a----        17-11-2023     23:48         568832 Windows.Media.Speech.UXRes.dll
-a----        15-07-2024     15:49        1135104 Windows.Media.Streaming.dll
-a----        07-12-2019     15:22         218624 Windows.Media.Streaming.ps.dll
-a----        15-07-2024     15:49        4374248 Windows.Mirage.dll
-a----        17-11-2023     23:50          59392 Windows.Mirage.Internal.Capture.Pipeline.ProxyStub.dll
-a----        15-07-2024     15:49         867328 Windows.Mirage.Internal.dll
-a----        15-07-2024     15:46         107008 Windows.Networking.BackgroundTransfer.BackgroundManagerPolicy.dll
-a----        17-11-2023     23:48         505856 Windows.Networking.BackgroundTransfer.ContentPrefetchTask.dll
-a----        15-07-2024     15:46        1299968 Windows.Networking.BackgroundTransfer.dll
-a----        15-07-2024     15:46         737280 Windows.Networking.Connectivity.dll
-a----        15-07-2024     15:46         937472 Windows.Networking.dll
-a----        17-11-2023     23:48         215552 Windows.Networking.HostName.dll
-a----        15-07-2024     15:47         399872 Windows.Networking.NetworkOperators.ESim.dll
-a----        15-07-2024     15:46         143360 Windows.Networking.NetworkOperators.HotspotAuthentication.dll
-a----        17-11-2023     23:48         349184 Windows.Networking.Proximity.dll
-a----        17-11-2023     23:48         117760 Windows.Networking.ServiceDiscovery.Dnssd.dll
-a----        17-11-2023     23:48         148480 Windows.Networking.Sockets.PushEnabledApplication.dll
-a----        15-07-2024     15:47         631296 Windows.Networking.UX.EapRequestHandler.dll
-a----        15-07-2024     15:47        1523200 Windows.Networking.Vpn.dll
-a----        07-12-2019     14:39          75776 Windows.Networking.XboxLive.ProxyStub.dll
-a----        15-07-2024     15:47         588800 Windows.Payments.dll
-a----        15-07-2024     15:46        1058344 Windows.Perception.Stub.dll
-a----        15-07-2024     15:47         269824 Windows.Security.Authentication.Identity.Provider.dll
-a----        15-07-2024     15:46         975872 Windows.Security.Authentication.OnlineId.dll
-a----        15-07-2024     15:46        1146368 Windows.Security.Authentication.Web.Core.dll
-a----        15-07-2024     15:46         115880 Windows.Security.Credentials.UI.CredentialPicker.dll
-a----        15-07-2024     15:46         143872 Windows.Security.Credentials.UI.UserConsentVerifier.dll
-a----        15-07-2024     15:46          99808 Windows.Security.Integrity.dll
-a----        15-07-2024     15:47        1187712 Windows.Services.TargetedContent.dll
-a----        15-07-2024     15:47         223744 Windows.SharedPC.AccountManager.dll
-a----        15-07-2024     15:47         161792 Windows.SharedPC.CredentialProvider.dll
-a----        15-07-2024     15:47         326656 Windows.Shell.BlueLightReduction.dll
-a----        15-07-2024     15:47          99840 Windows.Shell.ServiceHostBuilder.dll
-a----        07-12-2019     14:38          22528 Windows.Shell.StartLayoutPopulationEvents.dll
-a----        15-07-2024     15:47        5861784 Windows.StateRepository.dll
-a----        17-11-2023     23:48         118768 Windows.StateRepositoryBroker.dll
-a----        15-07-2024     15:47         250736 Windows.StateRepositoryClient.dll
-a----        15-07-2024     15:47          59448 Windows.StateRepositoryCore.dll
-a----        17-11-2023     23:48        1338880 Windows.StateRepositoryPS.dll
-a----        15-07-2024     15:47         268800 Windows.StateRepositoryUpgrade.dll
-a----        15-07-2024     15:46         410776 Windows.Storage.ApplicationData.dll
-a----        29-10-2023     08:35         182784 Windows.Storage.Compression.dll
-a----        15-07-2024     15:47        8026064 windows.storage.dll
-a----        15-07-2024     15:47         203264 Windows.Storage.OneCore.dll
-a----        15-07-2024     15:46         798720 Windows.Storage.Search.dll
-a----        15-07-2024     15:46         356352 Windows.System.Diagnostics.dll
-a----        15-07-2024     15:46          55808 Windows.System.Diagnostics.Telemetry.PlatformTelemetryClient.dll
-a----        15-07-2024     15:46         107520 Windows.System.Diagnostics.TraceReporting.PlatformDiagnosticActions.dll
-a----        15-07-2024     15:46         756736 Windows.System.Launcher.dll
-a----        23-02-2024     23:42         150880 Windows.System.Profile.HardwareId.dll
-a----        15-07-2024     15:46          72192 Windows.System.Profile.PlatformDiagnosticsAndUsageDataSettings.dll
-a----        15-07-2024     15:47         141312 Windows.System.Profile.RetailInfo.dll
-a----        15-07-2024     15:46          62464 Windows.System.Profile.SystemId.dll
-a----        15-07-2024     15:46          54784 Windows.System.Profile.SystemManufacturers.dll
-a----        17-11-2023     23:48          23552 Windows.System.RemoteDesktop.dll
-a----        15-07-2024     15:46         322048 Windows.System.SystemManagement.dll
-a----        15-07-2024     15:46          94208 Windows.System.UserDeviceAssociation.dll
-a----        15-07-2024     15:46          65024 Windows.System.UserProfile.DiagnosticsSettings.dll
-a----        15-07-2024     15:46         105472 Windows.UI.Accessibility.dll
-a----        15-07-2024     15:46         287744 Windows.UI.AppDefaults.dll
-a----        15-07-2024     15:49         363520 Windows.UI.BioFeedback.dll
-a----        15-07-2024     15:47         409088 Windows.UI.BlockedShutdown.dll
-a----        15-07-2024     15:47        1040896 Windows.UI.Core.TextInput.dll
-a----        15-07-2024     15:47        1591808 Windows.UI.Cred.dll
-a----        15-07-2024     15:47         326144 Windows.UI.CredDialogController.dll
-a----        15-07-2024     15:47        1310360 Windows.UI.dll
-a----        15-07-2024     15:47         274432 Windows.UI.FileExplorer.dll
-a----        15-07-2024     15:47        1256448 Windows.UI.Immersive.dll
-a----        07-12-2019     14:38        4511744 Windows.UI.Input.Inking.Analysis.dll
-a----        15-07-2024     15:47        1824256 Windows.UI.Input.Inking.dll
-a----        15-07-2024     15:46         199168 Windows.UI.Internal.Input.ExpressiveInput.dll
-a----        07-12-2019     14:38          84480 Windows.UI.Internal.Input.ExpressiveInput.Resource.dll
-a----        15-07-2024     15:47        3093504 Windows.UI.Logon.dll
-a----        15-07-2024     15:47          86016 Windows.UI.NetworkUXController.dll
-a----        15-07-2024     15:49        2744320 Windows.UI.PicturePassword.dll
-a----        15-07-2024     15:47         911872 Windows.UI.Search.dll
-a----        15-07-2024     15:49          41472 Windows.UI.Shell.dll
-a----        17-11-2023     23:48        1432064 Windows.UI.Shell.Internal.AdaptiveCards.dll
-a----        15-07-2024     15:46         141312 Windows.UI.Storage.dll
-a----        15-07-2024     15:46        4025344 Windows.UI.Xaml.Controls.dll
-a----        15-07-2024     15:46       17531392 Windows.UI.Xaml.dll
-a----        15-07-2024     15:46         974336 Windows.UI.Xaml.InkControls.dll
-a----        15-07-2024     15:46        1360896 Windows.UI.Xaml.Maps.dll
-a----        15-07-2024     15:46        1268224 Windows.UI.Xaml.Phone.dll
-a----        07-12-2019     14:38         706048 Windows.UI.Xaml.Resources.19h1.dll
-a----        15-07-2024     15:46          44032 Windows.UI.Xaml.Resources.Common.dll
-a----        07-12-2019     14:38         456704 Windows.UI.Xaml.Resources.rs1.dll
-a----        07-12-2019     14:38         508928 Windows.UI.Xaml.Resources.rs2.dll
-a----        07-12-2019     14:38         617472 Windows.UI.Xaml.Resources.rs3.dll
-a----        07-12-2019     14:38         645632 Windows.UI.Xaml.Resources.rs4.dll
-a----        07-12-2019     14:38         700928 Windows.UI.Xaml.Resources.rs5.dll
-a----        07-12-2019     14:38         301056 Windows.UI.Xaml.Resources.th.dll
-a----        07-12-2019     14:38         241664 Windows.UI.Xaml.Resources.win81.dll
-a----        07-12-2019     14:38         142336 Windows.UI.Xaml.Resources.win8rtm.dll
-a----        15-07-2024     15:49         210944 Windows.UI.XamlHost.dll
-a----        15-07-2024     15:47          65536 Windows.WARP.JITService.dll
-a----        15-07-2024     15:47          73216 Windows.WARP.JITService.exe
-a----        15-07-2024     15:46         235520 Windows.Web.Diagnostics.dll
-a----        15-07-2024     15:46         775168 Windows.Web.dll
-a----        15-07-2024     15:46        1514496 Windows.Web.Http.dll
-a----        28-07-2024     12:12          72304 WindowsAccessBridge-64.dll
-a----        15-07-2024     15:48          62464 WindowsActionDialog.exe
-a----        15-07-2024     15:47        1792824 WindowsCodecs.dll
-a----        17-11-2023     23:48         274944 WindowsCodecsExt.dll
-a----        17-11-2023     23:50       32610352 WindowsCodecsRaw.dll
-a----        07-12-2019     14:40           1649 WindowsCodecsRaw.txt
-a----        15-07-2024     15:47         126976 WindowsDefaultHeatProcessor.dll
-a----        15-07-2024     15:47         732160 WindowsInternal.ComposableShell.ComposerFramework.dll
-a----        15-07-2024     15:47         169472 WindowsInternal.ComposableShell.DesktopHosting.dll
-a----        15-07-2024     15:47          77312 WindowsInternal.Shell.CompUiActivation.dll
-a----        15-07-2024     15:47         290304 windowslivelogin.dll
-a----        15-07-2024     15:46          84240 WindowsManagementServiceWinRt.ProxyStub.dll
-a----        15-07-2024     15:47        1211904 windowsperformancerecordercontrol.dll
-a----        07-12-2019     14:38            759 WindowsSecurityIcon.png
-a----        15-07-2024     15:47        2968064 windowsudk.shellcommon.dll
-a----        15-07-2024     15:47          70656 WindowsUpdateElevatedInstaller.exe
-a----        17-11-2023     23:49          93184 winethc.dll
-a----        15-07-2024     15:49          31744 WinFax.dll
-a----        15-07-2024     15:47        1088808 winhttp.dll
-a----        17-11-2023     23:49         102912 winhttpcom.dll
-a----        15-07-2024     15:48         130048 WinHvEmulation.dll
-a----        15-07-2024     15:48         135168 WinHvPlatform.dll
-a----        15-07-2024     15:47        5039616 wininet.dll
-a----        07-12-2019     14:39          70144 wininetlui.dll
-a----        15-07-2024     15:47         424648 wininit.exe
-a----        15-07-2024     15:47          83320 wininitext.dll
-a----        15-07-2024     15:47         513024 winipcfile.dll
-a----        15-07-2024     15:47         904704 winipcsecproc.dll
-a----        17-11-2023     23:48         101888 winipsec.dll
-a----        07-12-2019     14:38         150528 winjson.dll
-a----        15-07-2024     15:47         190464 Winlangdb.dll
-a----        15-07-2024     15:47        1848128 winload.efi
-a----        15-07-2024     15:47        1573808 winload.exe
-a----        15-07-2024     15:47         905728 winlogon.exe
-a----        15-07-2024     15:47          86016 winlogonext.dll
-a----        17-11-2023     23:50        1771752 winmde.dll
-a----        07-12-2019     14:38          41472 winml.dll
-a----        17-11-2023     23:47         148376 winmm.dll
-a----        07-12-2019     14:38         144592 winmmbase.dll
-a----        15-07-2024     15:47        2351104 winmsipc.dll
-a----        17-11-2023     23:48          88064 WinMsoIrmProtector.dll
-a----        15-07-2024     15:47          19968 winnlsres.dll
-a----        17-11-2023     23:48          36808 winnsi.dll
-a----        17-11-2023     23:48          81920 WinOpcIrmProtector.dll
-a----        15-07-2024     15:47         549760 WinREAgent.dll
-a----        15-07-2024     15:47        1410080 winresume.efi
-a----        15-07-2024     15:47        1208144 winresume.exe
-a----        07-12-2019     14:38             33 winrm.cmd
-a----        07-12-2019     14:38         204074 winrm.vbs
-a----        17-11-2023     23:48          49152 winrnr.dll
-a----        07-12-2019     14:38          52736 winrs.exe
-a----        17-11-2023     23:48         122368 winrscmd.dll
-a----        07-12-2019     14:38          29184 winrshost.exe
-a----        07-12-2019     14:38           2048 winrsmgr.dll
-a----        07-12-2019     14:38          14848 winrssrv.dll
-a----        17-11-2023     23:48          20480 WinRTNetMUAHostServer.exe
-a----        17-11-2023     23:48         184832 WinRtTracing.dll
-a----        17-11-2023     23:49        2811392 WinSAT.exe
-a----        17-11-2023     23:49         377856 WinSATAPI.dll
-a----        17-11-2023     23:48         252928 WinSCard.dll
-a----        17-11-2023     23:49         390632 WinSetupUI.dll
-a----        17-11-2023     23:48          19968 winshfhc.dll
-a----        15-07-2024     15:47         334848 winsku.dll
-a----        17-11-2023     23:48          98304 winsockhc.dll
-a----        15-07-2024     15:46         651264 winspool.drv
-a----        15-07-2024     15:47        1070824 winsqlite3.dll
-a----        07-12-2019     14:39          26624 WINSRPC.DLL
-a----        07-12-2019     14:38          62976 winsrv.dll
-a----        17-11-2023     23:48         103424 winsrvext.dll
-a----        17-11-2023     23:49         353440 winsta.dll
-a----        07-12-2019     14:38         822272 WinSync.dll
-a----        07-12-2019     14:39         230400 WinSyncMetastore.dll
-a----        07-12-2019     14:39         136704 WinSyncProviders.dll
-a----        15-07-2024     15:47         423032 wintrust.dll
-a----        15-07-2024     15:47        1408088 WinTypes.dll
-a----        07-12-2019     14:38          29696 winusb.dll
-a----        07-12-2019     14:39          59392 winver.exe
-a----        17-11-2023     23:47          45568 WiredNetworkCSP.dll
-a----        15-07-2024     15:47         260096 wisp.dll
-a----        17-11-2023     23:48          37376 witnesswmiv2provider.dll
-a----        17-11-2023     23:48          92112 wkscli.dll
-a----        15-07-2024     15:48         290400 wkspbroker.exe
-a----        15-07-2024     15:48         140288 wkspbrokerAx.dll
-a----        17-11-2023     23:49         450560 wksprt.exe
-a----        07-12-2019     14:38          31744 wksprtPS.dll
-a----        15-07-2024     15:47         308224 wkssvc.dll
-a----        15-07-2024     15:46         471184 wlanapi.dll
-a----        17-11-2023     23:47         310784 wlancfg.dll
-a----        17-11-2023     23:49         588800 WLanConn.dll
-a----        17-11-2023     23:47         202240 wlandlg.dll
-a----        07-12-2019     14:38         103424 wlanext.exe
-a----        17-11-2023     23:47         394752 wlangpui.dll
-a----        17-11-2023     23:47         216064 WLanHC.dll
-a----        17-11-2023     23:47          16896 wlanhlp.dll
-a----        15-07-2024     15:47         755712 WlanMediaManager.dll
-a----        17-11-2023     23:49         400384 WlanMM.dll
-a----        15-07-2024     15:46         436224 wlanmsm.dll
-a----        17-11-2023     23:47         776704 wlanpref.dll
-a----        17-11-2023     23:47          69120 WlanRadioManager.dll
-a----        15-07-2024     15:46         481280 wlansec.dll
-a----        15-07-2024     15:46        2654208 wlansvc.dll
-a----        17-11-2023     23:47          36352 wlansvcpal.dll
-a----        17-11-2023     23:48         422400 wlanui.dll
-a----        07-12-2019     14:38           3584 wlanutil.dll
-a----        15-07-2024     15:47         356864 Wldap32.dll
-a----        15-07-2024     15:47         184520 wldp.dll
-a----        17-11-2023     23:47         122368 wlgpclnt.dll
-a----        15-07-2024     15:47         713728 wlidcli.dll
-a----        15-07-2024     15:47         300544 wlidcredprov.dll
-a----        20-01-2024     11:02         102400 wlidfdp.dll
-a----        20-01-2024     11:02          67072 wlidnsp.dll
-a----        15-07-2024     15:46         667136 wlidprov.dll
-a----        07-12-2019     14:38          30208 wlidres.dll
-a----        15-07-2024     15:46        2256896 wlidsvc.dll
-a----        17-11-2023     23:49          69264 wlrmdr.exe
-a----        17-11-2023     23:50         761392 WMADMOD.DLL
-a----        17-11-2023     23:50         745432 WMADMOE.DLL
-a----        15-07-2024     15:46        1820704 WMALFXGFXDSP.dll
-a----        07-12-2019     15:22         341904 WMASF.DLL
-a----        07-12-2019     15:22          14336 wmcodecdspps.dll
-a----        17-11-2023     23:50          40960 wmdmlog.dll
-a----        07-12-2019     15:22          95744 wmdmps.dll
-a----        07-12-2019     14:39           7680 wmdrmsdk.dll
-a----        07-12-2019     03:01           2560 wmerror.dll
-a----        07-12-2019     14:38           5632 wmi.dll
-a----        17-11-2023     23:47          49152 wmiclnt.dll
-a----        17-11-2023     23:47         361952 wmicmiplugin.dll
-a----        17-11-2023     23:48         176640 wmidcom.dll
-a----        17-11-2023     23:50         202752 wmidx.dll
-a----        07-12-2019     14:38         144673 WmiMgmt.msc
-a----        07-12-2019     14:39          31232 wmiprop.dll
-a----        07-12-2019     14:38         215552 wmitomi.dll
-a----        17-11-2023     23:50        1357312 WMNetMgr.dll
-a----        15-07-2024     15:49       11455488 wmp.dll
-a----        17-11-2023     23:50        1568256 WMPDMC.exe
-a----        07-12-2019     15:22         373248 WmpDui.dll
-a----        17-11-2023     23:50         221696 wmpdxm.dll
-a----        17-11-2023     23:50         312640 wmpeffects.dll
-a----        17-11-2023     23:48         381952 WMPhoto.dll
-a----        17-11-2023     23:50           2560 wmploc.DLL
-a----        17-11-2023     23:50         389544 wmpps.dll
-a----        17-11-2023     23:50         129024 wmpshell.dll
-a----        15-07-2024     15:47          20480 wmsgapi.dll
-a----        07-12-2019     14:38         993792 WMSPDMOD.DLL
-a----        17-11-2023     23:50        1253376 WMSPDMOE.DLL
-a----        23-02-2024     23:42        2454544 WMVCORE.DLL
-a----        23-02-2024     23:42        2524808 WMVDECOD.DLL
-a----        17-11-2023     23:50         214016 wmvdspa.dll
-a----        07-12-2019     15:22        2298600 WMVENCOD.DLL
-a----        07-12-2019     15:22         347096 WMVSDECD.DLL
-a----        07-12-2019     15:22         451584 WMVSENCD.DLL
-a----        17-11-2023     23:50         689664 WMVXENCD.DLL
-a----        07-12-2019     15:22          30720 WofTasks.dll
-a----        07-12-2019     14:38          36352 WofUtil.dll
-a----        15-07-2024     15:47          44032 WordBreakers.dll
-a----        17-11-2023     23:49         105472 WorkFolders.exe
-a----        15-07-2024     15:49         893952 WorkfoldersControl.dll
-a----        07-12-2019     14:39         108544 WorkFoldersGPExt.dll
-a----        07-12-2019     14:39          61952 WorkFoldersRes.dll
-a----        15-07-2024     15:49         230400 WorkFoldersShell.dll
-a----        15-07-2024     15:49        2233320 workfolderssvc.dll
-a----        15-07-2024     15:46         349184 wosc.dll
-a----        17-11-2023     23:48         354904 wow64.dll
-a----        17-11-2023     23:48          22464 wow64cpu.dll
-a----        23-02-2024     23:39         533152 wow64win.dll
-a----        17-11-2023     23:49          17920 wowreg32.exe
-a----        17-11-2023     23:47         452608 WpAXHolder.dll
-a----        07-12-2019     14:38         103424 wpbcreds.dll
-a----        15-07-2024     15:46        1651200 Wpc.dll
-a----        15-07-2024     15:46         336896 WpcApi.dll
-a----        07-12-2019     14:38          10143 wpcatltoast.png
-a----        15-07-2024     15:46        1869824 WpcDesktopMonSvc.dll
-a----        15-07-2024     15:46        1188048 WpcMon.exe
-a----        07-12-2019     14:38           4687 wpcmon.png
-a----        15-07-2024     15:46          40960 WpcProxyStubs.dll
-a----        15-07-2024     15:46        1050624 WpcRefreshTask.dll
-a----        15-07-2024     15:46         289280 WpcTok.exe
-a----        15-07-2024     15:46         859136 WpcWebFilter.dll
-a----        17-11-2023     23:50         101888 wpdbusenum.dll
-a----        15-07-2024     15:46         232448 WpdMtp.dll
-a----        15-07-2024     15:46         161792 WpdMtpUS.dll
-a----        15-07-2024     15:49         636416 wpdshext.dll
-a----        17-11-2023     23:50          30720 WPDShextAutoplay.exe
-a----        17-11-2023     23:50          67072 WPDShServiceObj.dll
-a----        15-07-2024     15:49         385024 WPDSp.dll
-a----        17-11-2023     23:50         230912 wpd_ci.dll
-a----        15-07-2024     15:47        1400320 wpnapps.dll
-a----        15-07-2024     15:47         368640 wpnclient.dll
-a----        15-07-2024     15:47        1507840 wpncore.dll
-a----        07-12-2019     14:38          24064 wpninprc.dll
-a----        17-11-2023     23:49          22528 wpnpinst.exe
-a----        15-07-2024     15:47         650752 wpnprv.dll
-a----        15-07-2024     15:47         245760 wpnservice.dll
-a----        07-12-2019     14:38          37888 wpnsruprov.dll
-a----        15-07-2024     15:47          86016 WpnUserService.dll
-a----        07-12-2019     14:38          14848 WpPortingLibrary.dll
-a----        07-12-2019     14:38          11776 WppRecorderUM.dll
-a----        07-12-2019     14:38            724 wpr.config.xml
-a----        15-07-2024     15:47         321024 wpr.exe
-a----        17-11-2023     23:49         176128 WPTaskScheduler.dll
-a----        15-07-2024     15:46        1329632 wpx.dll
-a----        07-12-2019     02:59          11264 write.exe
-a----        07-12-2019     14:38           4608 ws2help.dll
-a----        17-11-2023     23:48         429408 ws2_32.dll
-a----        17-11-2023     23:47           9216 wscadminui.exe
-a----        17-11-2023     23:47         299192 wscapi.dll
-a----        17-11-2023     23:49         223744 wscinterop.dll
-a----        17-11-2023     23:47          28160 wscisvif.dll
-a----        07-12-2019     14:38          13824 WSClient.dll
-a----        17-11-2023     23:48          95232 WSCollect.exe
-a----        17-11-2023     23:47          18944 wscproxystub.dll
-a----        15-07-2024     15:47         196608 wscript.exe
-a----        15-07-2024     15:46         354904 wscsvc.dll
-a----        17-11-2023     23:49          84992 wscui.cpl
-a----        15-07-2024     15:47         692736 WSDApi.dll
-a----        15-07-2024     15:48          57344 wsdchngr.dll
-a----        17-11-2023     23:49          92672 WSDPrintProxy.DLL
-a----        29-10-2023     08:36          24576 WsdProviderUtil.dll
-a----        17-11-2023     23:49          70656 WSDScanProxy.dll
-a----        15-07-2024     15:46         276992 WSDScDrv.dll
-a----        17-11-2023     23:49         706048 wsecedit.dll
-a----        15-07-2024     15:47          89088 wsepno.dll
-a----        17-11-2023     23:48          64000 wshbth.dll
-a----        29-10-2023     08:36          25088 wshcon.dll
-a----        07-12-2019     14:38          23040 wshelper.dll
-a----        29-10-2023     08:36         103424 wshext.dll
-a----        17-11-2023     23:49          19768 wshhyperv.dll
-a----        17-11-2023     23:48          12800 wship6.dll
-a----        29-10-2023     08:36         147456 wshom.ocx
-a----        17-11-2023     23:48          20480 wshqos.dll
-a----        15-07-2024     15:48          18944 wshrm.dll
-a----        17-11-2023     23:48          12800 WSHTCPIP.DLL
-a----        07-12-2019     14:39          17560 wshunix.dll
-a----        15-07-2024     15:49         172544 wsl.exe
-a----        15-07-2024     15:49         291840 wslapi.dll
-a----        15-07-2024     15:49          91136 wslconfig.exe
-a----        17-11-2023     23:48          32768 WsmAgent.dll
-a----        07-12-2019     14:38           4675 wsmanconfig_schema.xml
-a----        17-11-2023     23:48          43008 WSManHTTPConfig.exe
-a----        17-11-2023     23:48          88576 WSManMigrationPlugin.dll
-a----        17-11-2023     23:48         180224 WsmAuto.dll
-a----        17-11-2023     23:48          16384 wsmplpxy.dll
-a----        17-11-2023     23:48          46592 wsmprovhost.exe
-a----        07-12-2019     14:38           1559 WsmPty.xsl
-a----        17-11-2023     23:48          61952 WsmRes.dll
-a----        15-07-2024     15:47        2812416 WsmSvc.dll
-a----        07-12-2019     14:38           2426 WsmTxt.xsl
-a----        17-11-2023     23:48         322048 WsmWmiPl.dll
-a----        07-12-2019     14:38          66048 wsnmp32.dll
-a----        07-12-2019     14:38          18944 wsock32.dll
-a----        07-12-2019     14:39          45568 wsplib.dll
-a----        15-07-2024     15:48        2025344 wsp_fs.dll
-a----        15-07-2024     15:48        1763312 wsp_health.dll
-a----        07-12-2019     14:39         965944 wsp_sr.dll
-a----        15-07-2024     15:47         120320 wsqmcons.exe
-a----        17-11-2023     23:48          94208 WSReset.exe
-a----        07-12-2019     14:39          95232 WSTPager.ax
-a----        17-11-2023     23:49          68368 wtsapi32.dll
-a----        15-07-2024     15:47         956416 wuapi.dll
-a----        17-11-2023     23:48          11264 wuapihost.exe
-a----        15-07-2024     15:47          66760 wuauclt.exe
-a----        15-07-2024     15:47        3436032 wuaueng.dll
-a----        15-07-2024     15:47         246784 wuceffects.dll
-a----        07-12-2019     14:38          51200 WUDFCoinstaller.dll
-a----        20-01-2024     11:02         161872 WUDFCompanionHost.exe
-a----        20-01-2024     11:02         270336 WUDFHost.exe
-a----        20-01-2024     11:02         196952 WUDFPlatform.dll
-a----        07-12-2019     14:39          55808 WudfSMCClassExt.dll
-a----        17-11-2023     23:49         595456 WUDFx.dll
-a----        15-07-2024     15:47         764968 WUDFx02000.dll
-a----        15-07-2024     15:47         127488 wudriver.dll
-a----        15-07-2024     15:47          85504 wups.dll
-a----        15-07-2024     15:47          64000 wups2.dll
-a----        15-07-2024     15:46         345088 wusa.exe
-a----        15-07-2024     15:47         525824 wuuhext.dll
-a----        15-07-2024     15:47         267776 wuuhosdeployment.dll
-a----        29-10-2023     08:37         580096 wvc.dll
-a----        15-07-2024     15:47         569344 WwaApi.dll
-a----        15-07-2024     15:47          40960 WwaExt.dll
-a----        15-07-2024     15:47         996224 WWAHost.exe
-a----        17-11-2023     23:47         579640 WWanAPI.dll
-a----        07-12-2019     14:39         105472 wwancfg.dll
-a----        15-07-2024     15:48         506880 wwanconn.dll
-a----        17-11-2023     23:49          73216 WWanHC.dll
-a----        15-07-2024     15:48         553472 wwanmm.dll
-a----        17-11-2023     23:49          52736 Wwanpref.dll
-a----        17-11-2023     23:47         112128 wwanprotdim.dll
-a----        15-07-2024     15:48          91648 WwanRadioManager.dll
-a----        15-07-2024     15:46        1517056 wwansvc.dll
-a----        17-11-2023     23:47          98792 wwapi.dll
-a----        15-07-2024     15:46         234496 XamlTileRender.dll
-a----        07-12-2019     14:38           3584 XAudio2_8.dll
-a----        15-07-2024     15:46         638976 XAudio2_9.dll
-a----        15-07-2024     15:46        1049088 XblAuthManager.dll
-a----        17-11-2023     23:47          93696 XblAuthManagerProxy.dll
-a----        15-07-2024     15:46         114688 XblAuthTokenBrokerExt.dll
-a----        15-07-2024     15:46        1291264 XblGameSave.dll
-a----        15-07-2024     15:46         159744 XblGameSaveExt.dll
-a----        15-07-2024     15:46          33792 XblGameSaveTask.exe
-a----        15-07-2024     15:46          72704 xboxgipsvc.dll
-a----        17-11-2023     23:49        1295360 XboxNetApiSvc.dll
-a----        17-11-2023     23:49          45568 XInput1_4.dll
-a----        15-07-2024     15:46          49664 XInputUap.dll
-a----        17-11-2023     23:48         216440 xmllite.dll
-a----        15-07-2024     15:48         109056 xolehlp.dll
-a----        17-11-2023     23:50         820224 XpsFilt.dll
-a----        15-07-2024     15:47         456192 XpsGdiConverter.dll
-a----        15-07-2024     15:47        1515008 XpsPrint.dll
-a----        15-07-2024     15:47         379392 xpspushlayer.dll
-a----        17-11-2023     23:49         581120 XpsRasterService.dll
-a----        16-10-2019     03:23          76060 xpsrchvw.xml
-a----        23-02-2024     23:41        2844672 xpsservices.dll
-a----        17-11-2023     23:50         104960 XPSSHHDR.dll
-a----        15-07-2024     15:47         268288 XpsToPclmConverter.dll
-a----        15-07-2024     15:47          78336 XpsToPwgrConverter.dll
-a----        07-12-2019     14:39          64000 xwizard.exe
-a----        17-11-2023     23:49         452608 xwizards.dll
-a----        17-11-2023     23:49         121344 xwreg.dll
-a----        17-11-2023     23:49         267776 xwtpdui.dll
-a----        07-12-2019     14:38            627 X_80.contrast-black.png
-a----        07-12-2019     14:38            627 X_80.png
-a----        02-08-2021     19:21         376136 ze_loader.dll
-a----        02-08-2021     19:21         459080 ze_tracing_layer.dll
-a----        02-08-2021     19:21         148280 ze_validation_layer.dll
-a----        15-07-2024     15:47         302592 zipfldr.dll
-a----        07-12-2019     14:38          30720 ztrace_maps.dll


PS C:\windows\system32> kubectl apply -f .\nginx-deployment.yaml
error: no objects passed to apply
PS C:\windows\system32> kubectl apply -f nginx-deployment.yaml
error: no objects passed to apply
PS C:\windows\system32> kubectl apply -f ./nginx-deployment.yaml
error: no objects passed to apply
PS C:\windows\system32> kubectl apply -f .\nginx-deployment.yaml
error: no objects passed to apply
PS C:\windows\system32> kubectl apply -f .\nginx-deployment.yaml
error: no objects passed to apply
PS C:\windows\system32> kubectl apply -f nginx-deployment.yaml
error: no objects passed to apply
PS C:\windows\system32> kubectl apply -f C:\nginx\nginx-deployment.yaml
deployment.apps/nginx-deployment created
PS C:\windows\system32> kubectl exec -it mongo-depl-887485654-qjj6d -- bin/bash
root@mongo-depl-887485654-qjj6d:/# kubectl apply -f nginx-deployment.yaml
bash: kubectl: command not found
root@mongo-depl-887485654-qjj6d:/# exit
exit
command terminated with exit code 127
PS C:\windows\system32> kubectl get pod
NAME                                READY   STATUS    RESTARTS   AGE
mongo-depl-887485654-qjj6d          1/1     Running   0          34m
nginx-depl-85c9d7c5f4-tsvlq         1/1     Running   0          46m
nginx-deployment-77d8468669-5dhnz   1/1     Running   0          3m40s
nginx-deployment-77d8468669-jmhxr   1/1     Running   0          3m40s
PS C:\windows\system32> kubectl get deployment
NAME               READY   UP-TO-DATE   AVAILABLE   AGE
mongo-depl         1/1     1            1           35m
nginx-depl         1/1     1            1           47m
nginx-deployment   2/2     2            2           4m23s
PS C:\windows\system32> kubectl apply -f C:\nginx\nginx-deployment.yaml
deployment.apps/nginx-deployment configured
PS C:\windows\system32> kubectl get pod
NAME                                READY   STATUS    RESTARTS   AGE
mongo-depl-887485654-qjj6d          1/1     Running   0          36m
nginx-depl-85c9d7c5f4-tsvlq         1/1     Running   0          48m
nginx-deployment-77d8468669-jmhxr   1/1     Running   0          5m39s
PS C:\windows\system32> kubectl get deployment
NAME               READY   UP-TO-DATE   AVAILABLE   AGE
mongo-depl         1/1     1            1           36m
nginx-depl         1/1     1            1           48m
nginx-deployment   1/1     1            1           5m49s
PS C:\windows\system32>


==================================

-a----        15-07-2024     15:47         654336 ipnathlp.dll
-a----        07-12-2019     14:39          32768 IpNatHlpClient.dll
-a----        15-07-2024     15:47         112128 IppCommon.dll
-a----        22-03-2024     13:02          17920 IppCommonProxy.dll
-a----        20-01-2024     11:02          11776 iprtprio.dll
-a----        15-07-2024     15:47         629760 iprtrmgr.dll
-a----        17-11-2023     23:48         422912 ipsecsnp.dll
-a----        17-11-2023     23:48         463360 IPSECSVC.DLL
-a----        17-11-2023     23:48         532480 ipsmsnap.dll
-a----        07-12-2019     14:38          66048 ipxlatcfg.dll
-a----        17-11-2023     23:48          52224 iri.dll
-a----        07-12-2019     14:39          37376 irprops.cpl
-a----        15-07-2024     15:48          50688 iscsicli.exe
-a----        07-12-2019     14:39         109568 iscsicpl.dll
-a----        07-12-2019     14:39          12800 iscsicpl.exe
-a----        15-07-2024     15:48          79872 iscsidsc.dll
-a----        15-07-2024     15:48          12800 iscsied.dll
-a----        15-07-2024     15:48         165888 iscsiexe.dll
-a----        17-11-2023     23:47          16896 iscsilog.dll
-a----        15-07-2024     15:48          37376 iscsium.dll
-a----        15-07-2024     15:48          84480 iscsiwmi.dll
-a----        15-07-2024     15:48         131072 iscsiwmiv2.dll
-a----        15-07-2024     15:47        2252288 ISM.dll
-a----        15-07-2024     15:48         122368 isoburn.exe
-a----        17-11-2023     23:49         205824 itircl.dll
-a----        07-12-2019     14:39         177152 itss.dll
-a----        15-07-2024     15:47          53904 iuilp.dll
-a----        17-11-2023     23:49          27040 iumbase.dll
-a----        15-07-2024     15:47          70808 iumcrypt.dll
-a----        17-11-2023     23:49          16728 iumdll.dll
-a----        07-12-2019     14:39          22624 IumSdk.dll
-a----        07-12-2019     14:39          54272 iyuv_32.dll
-a----        17-11-2023     23:49          90624 JavaScriptCollectionAgent.dll
-a----        30-11-2020     03:28         337288 JHI64.dll
-a----        17-11-2023     23:49          60416 joinproviderol.dll
-a----        17-11-2023     23:49         151552 joinutil.dll
-a----        07-12-2019     14:39          99328 joy.cpl
-a----        15-07-2024     15:47         700416 JpMapControl.dll
-a----        15-07-2024     15:46         381440 jpndecoder.dll
-a----        15-07-2024     15:46          81408 jpninputrouter.dll
-a----        15-07-2024     15:46         297472 jpnranker.dll
-a----        15-07-2024     15:47         245760 JpnServiceDS.dll
-a----        15-07-2024     15:48         854016 jscript.dll
-a----        15-07-2024     15:48        4887040 jscript9.dll
-a----        15-07-2024     15:48         714752 jscript9diag.dll
-a----        17-11-2023     23:48          53248 jsproxy.dll
-a----        07-12-2019     14:39           6948 kanji_1.uce
-a----        07-12-2019     14:39           8484 kanji_2.uce
-a----        17-11-2023     23:48           8704 kbd101.dll
-a----        07-12-2019     14:38           8192 kbd101a.dll
-a----        07-12-2019     14:38           8192 kbd101b.dll
-a----        07-12-2019     14:38           8192 kbd101c.dll
-a----        07-12-2019     14:38           8192 kbd103.dll
-a----        17-11-2023     23:48           8704 kbd106.dll
-a----        17-11-2023     23:48           8704 kbd106n.dll
-a----        07-12-2019     14:38           7680 KBDA1.DLL
-a----        07-12-2019     14:38           7680 KBDA2.DLL
-a----        07-12-2019     14:38           8192 KBDA3.DLL
-a----        07-12-2019     14:38           8192 KBDADLM.DLL
-a----        07-12-2019     14:38           8192 KBDAL.DLL
-a----        07-12-2019     14:38           7168 KBDARME.DLL
-a----        07-12-2019     14:38           8192 kbdarmph.dll
-a----        07-12-2019     14:38           8192 kbdarmty.dll
-a----        07-12-2019     14:38           7168 KBDARMW.DLL
-a----        07-12-2019     14:38           8704 kbdax2.dll
-a----        07-12-2019     14:38           8192 KBDAZE.DLL
-a----        07-12-2019     14:38           7680 KBDAZEL.DLL
-a----        07-12-2019     14:38           7680 KBDAZST.DLL
-a----        07-12-2019     14:38           7680 KBDBASH.DLL
-a----        07-12-2019     14:38           8192 KBDBE.DLL
-a----        07-12-2019     14:38           8192 KBDBENE.DLL
-a----        07-12-2019     14:38           7680 KBDBGPH.DLL
-a----        07-12-2019     14:38           8192 KBDBGPH1.DLL
-a----        07-12-2019     14:38           8192 KBDBHC.DLL
-a----        07-12-2019     14:38           7680 KBDBLR.DLL
-a----        07-12-2019     14:38           8192 KBDBR.DLL
-a----        07-12-2019     14:38           7680 KBDBU.DLL
-a----        07-12-2019     14:38           7680 KBDBUG.DLL
-a----        07-12-2019     14:38           7680 KBDBULG.DLL
-a----        07-12-2019     14:38           8192 KBDCA.DLL
-a----        07-12-2019     14:38           9728 KBDCAN.DLL
-a----        07-12-2019     14:38           8192 KBDCHER.DLL
-a----        07-12-2019     14:38          17920 KBDCHERP.DLL
-a----        07-12-2019     14:38           8704 KBDCR.DLL
-a----        07-12-2019     14:38           8704 KBDCZ.DLL
-a----        07-12-2019     14:38           9216 KBDCZ1.DLL
-a----        07-12-2019     14:38           8704 KBDCZ2.DLL
-a----        07-12-2019     14:38           7680 KBDDA.DLL
-a----        07-12-2019     14:38           7680 KBDDIV1.DLL
-a----        07-12-2019     14:38           7680 KBDDIV2.DLL
-a----        07-12-2019     14:38           7680 KBDDV.DLL
-a----        07-12-2019     14:38           8192 KBDDZO.DLL
-a----        07-12-2019     14:38           8704 KBDES.DLL
-a----        07-12-2019     14:38           8192 KBDEST.DLL
-a----        07-12-2019     14:38           7168 KBDFA.DLL
-a----        07-12-2019     14:38           8192 kbdfar.dll
-a----        07-12-2019     14:38           8704 KBDFC.DLL
-a----        07-12-2019     14:38           7680 KBDFI.DLL
-a----        07-12-2019     14:38           9216 KBDFI1.DLL
-a----        07-12-2019     14:38           7680 KBDFO.DLL
-a----        07-12-2019     14:38           7680 KBDFR.DLL
-a----        07-12-2019     14:38           8192 KBDFTHRK.DLL
-a----        07-12-2019     14:38           7680 KBDGAE.DLL
-a----        07-12-2019     14:38           7680 KBDGEO.DLL
-a----        07-12-2019     14:38           8192 kbdgeoer.dll
-a----        07-12-2019     14:38           7680 kbdgeome.dll
-a----        07-12-2019     14:38           8192 kbdgeooa.dll
-a----        07-12-2019     14:38           7680 kbdgeoqw.dll
-a----        07-12-2019     14:38           8704 KBDGKL.DLL
-a----        07-12-2019     14:38           8192 KBDGN.DLL
-a----        07-12-2019     14:38           7680 KBDGR.DLL
-a----        07-12-2019     14:38           8704 KBDGR1.DLL
-a----        07-12-2019     14:38           9216 KBDGRLND.DLL
-a----        07-12-2019     14:38           8192 KBDGTHC.DLL
-a----        07-12-2019     14:38           7680 KBDHAU.DLL
-a----        07-12-2019     14:38           8192 KBDHAW.DLL
-a----        07-12-2019     14:38           7680 KBDHE.DLL
-a----        07-12-2019     14:38           8192 KBDHE220.DLL
-a----        07-12-2019     14:38           8192 KBDHE319.DLL
-a----        07-12-2019     14:38           7680 KBDHEB.DLL
-a----        07-12-2019     14:38           8192 kbdhebl3.dll
-a----        07-12-2019     14:38           8192 KBDHELA2.DLL
-a----        07-12-2019     14:38           8192 KBDHELA3.DLL
-a----        07-12-2019     14:38          10752 KBDHEPT.DLL
-a----        07-12-2019     14:38           8704 KBDHU.DLL
-a----        07-12-2019     14:38           7680 KBDHU1.DLL
-a----        07-12-2019     14:38           8704 kbdibm02.dll
-a----        07-12-2019     14:38           8192 KBDIBO.DLL
-a----        07-12-2019     14:38           7680 KBDIC.DLL
-a----        07-12-2019     14:38           7680 KBDINASA.DLL
-a----        07-12-2019     14:38           7680 KBDINBE1.DLL
-a----        07-12-2019     14:38           7680 KBDINBE2.DLL
-a----        07-12-2019     14:38           8192 KBDINBEN.DLL
-a----        07-12-2019     14:38           8192 KBDINDEV.DLL
-a----        07-12-2019     14:38           9216 KBDINEN.DLL
-a----        07-12-2019     14:38           8192 KBDINGUJ.DLL
-a----        07-12-2019     14:38           8192 KBDINHIN.DLL
-a----        07-12-2019     14:38           8192 KBDINKAN.DLL
-a----        07-12-2019     14:38           8192 KBDINMAL.DLL
-a----        07-12-2019     14:38           8192 KBDINMAR.DLL
-a----        07-12-2019     14:38           8192 KBDINORI.DLL
-a----        07-12-2019     14:38           8192 KBDINPUN.DLL
-a----        07-12-2019     14:38           8192 KBDINTAM.DLL
-a----        07-12-2019     14:38           8192 KBDINTEL.DLL
-a----        07-12-2019     14:38           9216 KBDINUK2.DLL
-a----        07-12-2019     14:38           7168 KBDIR.DLL
-a----        07-12-2019     14:38           7168 KBDIT.DLL
-a----        07-12-2019     14:38           7680 KBDIT142.DLL
-a----        07-12-2019     14:38           8704 KBDIULAT.DLL
-a----        07-12-2019     14:38           8192 KBDJAV.DLL
-a----        17-11-2023     23:48          16384 KBDJPN.DLL
-a----        07-12-2019     14:38           7680 KBDKAZ.DLL
-a----        07-12-2019     14:38           8192 KBDKHMR.DLL
-a----        07-12-2019     14:38           8192 KBDKNI.DLL
-a----        07-12-2019     14:38          15872 KBDKOR.DLL
-a----        07-12-2019     14:38           8192 KBDKURD.DLL
-a----        07-12-2019     14:38           7168 KBDKYR.DLL
-a----        07-12-2019     14:38           8192 KBDLA.DLL
-a----        07-12-2019     14:38           8192 KBDLAO.DLL
-a----        07-12-2019     14:38           7680 kbdlisub.dll
-a----        07-12-2019     14:38           7680 kbdlisus.dll
-a----        07-12-2019     14:38           8704 kbdlk41a.dll
-a----        07-12-2019     14:38           7168 KBDLT.DLL
-a----        07-12-2019     14:38           7680 KBDLT1.DLL
-a----        07-12-2019     14:38           7680 KBDLT2.DLL
-a----        07-12-2019     14:38           7680 KBDLV.DLL
-a----        07-12-2019     14:38           8192 KBDLV1.DLL
-a----        07-12-2019     14:38           9216 KBDLVST.DLL
-a----        07-12-2019     14:38           7680 KBDMAC.DLL
-a----        07-12-2019     14:38           7680 KBDMACST.DLL
-a----        07-12-2019     14:38           7680 KBDMAORI.DLL
-a----        07-12-2019     14:38           8192 KBDMLT47.DLL
-a----        07-12-2019     14:38           8192 KBDMLT48.DLL
-a----        07-12-2019     14:38           7680 KBDMON.DLL
-a----        07-12-2019     14:38           7680 KBDMONMO.DLL
-a----        07-12-2019     14:38           7680 KBDMONST.DLL
-a----        07-12-2019     14:38           8192 KBDMYAN.DLL
-a----        07-12-2019     14:38           7680 KBDNE.DLL
-a----        07-12-2019     14:38           8704 kbdnec.dll
-a----        07-12-2019     14:38           9216 kbdnec95.dll
-a----        07-12-2019     14:38          10752 kbdnecat.dll
-a----        07-12-2019     14:38           9216 kbdnecnt.dll
-a----        07-12-2019     14:38           8192 KBDNEPR.DLL
-a----        07-12-2019     14:38           7168 kbdnko.dll
-a----        07-12-2019     14:38           7680 KBDNO.DLL
-a----        07-12-2019     14:38           9216 KBDNO1.DLL
-a----        07-12-2019     14:38           8704 KBDNSO.DLL
-a----        07-12-2019     14:38           8192 KBDNTL.DLL
-a----        07-12-2019     14:38           7680 KBDOGHAM.DLL
-a----        07-12-2019     14:38           7680 KBDOLCH.DLL
-a----        07-12-2019     14:38           7680 KBDOLDIT.DLL
-a----        07-12-2019     14:38           8192 KBDOSA.DLL
-a----        07-12-2019     14:38           7680 KBDOSM.DLL
-a----        07-12-2019     14:38           7680 KBDPASH.DLL
-a----        07-12-2019     14:38           8192 kbdphags.dll
-a----        07-12-2019     14:38           8704 KBDPL.DLL
-a----        07-12-2019     14:38           8192 KBDPL1.DLL
-a----        07-12-2019     14:38           8192 KBDPO.DLL
-a----        07-12-2019     14:38           9216 KBDRO.DLL
-a----        07-12-2019     14:38           9728 KBDROPR.DLL
-a----        07-12-2019     14:38           9728 KBDROST.DLL
-a----        07-12-2019     14:38           7680 KBDRU.DLL
-a----        07-12-2019     14:38           8192 KBDRU1.DLL
-a----        07-12-2019     14:38           9216 KBDRUM.DLL
-a----        07-12-2019     14:38           8192 KBDSF.DLL
-a----        07-12-2019     14:38           8704 KBDSG.DLL
-a----        07-12-2019     14:38           8192 KBDSL.DLL
-a----        07-12-2019     14:38           9216 KBDSL1.DLL
-a----        07-12-2019     14:38           9216 KBDSMSFI.DLL
-a----        07-12-2019     14:38           9216 KBDSMSNO.DLL
-a----        07-12-2019     14:38           7680 KBDSN1.DLL
-a----        07-12-2019     14:38           7680 KBDSORA.DLL
-a----        07-12-2019     14:38           8704 KBDSOREX.DLL
-a----        07-12-2019     14:38           8192 KBDSORS1.DLL
-a----        07-12-2019     14:38           8704 KBDSORST.DLL
-a----        07-12-2019     14:38           8192 KBDSP.DLL
-a----        07-12-2019     14:38           8192 KBDSW.DLL
-a----        07-12-2019     14:38           8704 KBDSW09.DLL
-a----        07-12-2019     14:38           8192 KBDSYR1.DLL
-a----        07-12-2019     14:38           8192 KBDSYR2.DLL
-a----        07-12-2019     14:38           8192 KBDTAILE.DLL
-a----        07-12-2019     14:38           7680 KBDTAJIK.DLL
-a----        07-12-2019     14:38           7680 KBDTAM99.DLL
-a----        07-12-2019     14:38           8192 KBDTAT.DLL
-a----        07-12-2019     14:38           7680 KBDTH0.DLL
-a----        07-12-2019     14:38           7680 KBDTH1.DLL
-a----        07-12-2019     14:38           7680 KBDTH2.DLL
-a----        07-12-2019     14:38           7680 KBDTH3.DLL
-a----        07-12-2019     14:38           8192 KBDTIFI.DLL
-a----        07-12-2019     14:38           8192 KBDTIFI2.DLL
-a----        07-12-2019     14:38           8704 KBDTIPRC.DLL
-a----        07-12-2019     14:38           8704 KBDTIPRD.DLL
-a----        07-12-2019     14:38           8192 KBDTT102.DLL
-a----        07-12-2019     14:38           8704 KBDTUF.DLL
-a----        07-12-2019     14:38           8704 KBDTUQ.DLL
-a----        07-12-2019     14:38           7680 KBDTURME.DLL
-a----        07-12-2019     14:38           8704 KBDTZM.DLL
-a----        07-12-2019     14:38           7680 KBDUGHR.DLL
-a----        07-12-2019     14:38           7680 KBDUGHR1.DLL
-a----        07-12-2019     14:38           7680 KBDUK.DLL
-a----        07-12-2019     14:38           8704 KBDUKX.DLL
-a----        07-12-2019     14:38           7168 KBDUR.DLL
-a----        07-12-2019     14:38           8192 KBDUR1.DLL
-a----        07-12-2019     14:38           7168 KBDURDU.DLL
-a----        17-11-2023     23:48           9728 KBDUS.DLL
-a----        07-12-2019     14:38           7680 KBDUSA.DLL
-a----        07-12-2019     14:38           7680 KBDUSL.DLL
-a----        07-12-2019     14:38           7680 KBDUSR.DLL
-a----        07-12-2019     14:38           8192 KBDUSX.DLL
-a----        07-12-2019     14:38           7680 KBDUZB.DLL
-a----        07-12-2019     14:38           7680 KBDVNTC.DLL
-a----        07-12-2019     14:38           8192 KBDWOL.DLL
-a----        07-12-2019     14:38           8192 KBDYAK.DLL
-a----        07-12-2019     14:38           8192 KBDYBA.DLL
-a----        07-12-2019     14:38           8192 KBDYCC.DLL
-a----        07-12-2019     14:38           9216 KBDYCL.DLL
-a----        07-12-2019     14:38          15672 kd.dll
-a----        07-12-2019     14:38          29712 kdcom.dll
-a----        15-07-2024     15:46          56832 kdcpw.dll
-a----        15-07-2024     15:48          22504 kdhvcom.dll
-a----        23-02-2024     23:40         126944 kdnet.dll
-a----        17-11-2023     23:49          18920 kdnet_uart16550.dll
-a----        23-02-2024     23:40          89600 KdsCli.dll
-a----        17-11-2023     23:48          28648 kdstub.dll
-a----        07-12-2019     14:39          45368 kdusb.dll
-a----        17-11-2023     23:49          32744 kd_02_10df.dll
-a----        17-11-2023     23:49         380376 kd_02_10ec.dll
-a----        17-11-2023     23:49          27624 kd_02_1137.dll
-a----        17-11-2023     23:49         241112 kd_02_14e4.dll
-a----        17-11-2023     23:49          45552 kd_02_15b3.dll
-a----        17-11-2023     23:49          45544 kd_02_1969.dll
-a----        17-11-2023     23:49          32728 kd_02_19a2.dll
-a----        17-11-2023     23:49          21480 kd_02_1af4.dll
-a----        17-11-2023     23:49         299496 kd_02_8086.dll
-a----        17-11-2023     23:49          19936 kd_07_1415.dll
-a----        17-11-2023     23:49          50144 kd_0C_8086.dll
-a----        17-11-2023     23:48          72192 keepaliveprovider.dll
-a----        15-07-2024     15:47         210312 KerbClientShared.dll
-a----        15-07-2024     15:47        1106944 kerberos.dll
-a----        20-01-2024     11:02          61528 kernel.appcore.dll
-a----        15-07-2024     15:47         781672 kernel32.dll
-a----        15-07-2024     15:47        3114048 KernelBase.dll
-a----        07-12-2019     14:38            841 KeyboardSystemToastIcon.contrast-white.png
-a----        07-12-2019     14:38            523 KeyboardSystemToastIcon.png
-a----        15-07-2024     15:47          71680 KeyCredMgr.dll
-a----        15-07-2024     15:47          99328 keyiso.dll
-a----        17-11-2023     23:49          59904 keymgr.dll
-a----        15-07-2024     15:47         125440 KeywordDetectorMsftSidAdapter.dll
-a----        15-07-2024     15:48          76288 klist.exe
-a----        07-12-2019     14:39          49152 kmddsp.tsp
-a----        15-07-2024     15:46         237568 KnobsCore.dll
-a----        17-11-2023     23:47         125952 KnobsCsp.dll
-a----        07-12-2019     14:39          12876 korean.uce
-a----        17-11-2023     23:49          40448 ksetup.exe
-a----        15-07-2024     15:48         304128 ksproxy.ax
-a----        07-12-2019     14:39         104960 kstvtune.ax
-a----        07-12-2019     14:38          23264 ksuser.dll
-a----        07-12-2019     14:39         141312 Kswdmcap.ax
-a----        07-12-2019     14:39          67584 ksxbar.ax
-a----        07-12-2019     14:39          18944 ktmutil.exe
-a----        17-11-2023     23:48          25088 ktmw32.dll
-a----        07-12-2019     14:38          72192 l2gpstore.dll
-a----        07-12-2019     14:38          63488 l2nacp.dll
-a----        15-07-2024     15:46         203264 L2SecHC.dll
-a----        07-12-2019     15:22          93184 l3codeca.acm
-a----        07-12-2019     15:22         184320 l3codecp.acm
-a----        07-12-2019     14:39          17920 label.exe
-a----        17-11-2023     23:48          16896 LangCleanupSysprepAction.dll
-a----        15-07-2024     15:47         181248 LanguageComponentsInstaller.dll
-a----        15-07-2024     15:47          52736 LanguageComponentsInstallerComHandler.exe
-a----        15-07-2024     15:46         410112 LanguageOverlayServer.dll
-a----        15-07-2024     15:46         253280 LanguageOverlayUtil.dll
-a----        15-07-2024     15:47          80384 LanguagePackDiskCleanup.dll
-a----        15-07-2024     15:46         101888 LanguagePackManagementCSP.dll
-a----        07-12-2019     15:22          13312 LAPRXY.DLL
-a----        15-07-2024     15:47         311296 laps.dll
-a----        15-07-2024     15:47         122368 lapscsp.dll
-a----        07-12-2019     14:38         190760 LaptopPlugInToastImg.gif
-a----        07-12-2019     14:38         149056 LargeRoom.bin
-a----        15-07-2024     15:47          11776 LaunchTM.exe
-a----        15-07-2024     15:47          45056 LaunchWinApp.exe
-a----        07-12-2019     14:39         211938 lcphrase.tbl
-a----        07-12-2019     14:39          24114 lcptr.tbl
-a----        17-11-2023     23:48          69632 LegacyNetUX.dll
-a----        15-07-2024     15:47         243712 LegacyNetUXHost.exe
-a----        15-07-2024     15:47          69632 LegacySystemSettings.dll
-a----        15-07-2024     15:47          48640 lfsvc.dll
-a----        15-05-2021     09:29        1687040 libcrypto.dll
-a----        02-08-2021     19:22         309664 libmfxhw64.dll
-a----        07-12-2019     15:18         138303 license.rtf
-a----        15-07-2024     15:47        1087872 LicenseManager.dll
-a----        15-07-2024     15:47          97280 LicenseManagerApi.dll
-a----        15-07-2024     15:47          48128 LicenseManagerShellext.exe
-a----        15-07-2024     15:47          51200 LicenseManagerSvc.dll
-a----        15-07-2024     15:46         149504 LicensingCSP.dll
-a----        20-01-2024     11:02         396288 licensingdiag.exe
-a----        15-07-2024     15:47         395776 LicensingDiagSpp.dll
-a----        17-11-2023     23:48         146816 LicensingUI.exe
-a----        15-07-2024     15:47         783856 LicensingWinRT.dll
-a----        07-12-2019     14:39          33280 licmgr10.dll
-a----        17-11-2023     23:48          31744 linkinfo.dll
-a----        15-07-2024     15:49         286208 ListSvc.dll
-a----        07-12-2019     14:38          49152 lltdapi.dll
-a----        07-12-2019     14:38           2560 lltdres.dll
-a----        17-11-2023     23:48         284672 lltdsvc.dll
-a----        07-12-2019     14:38          26112 lmhsvc.dll
-a----        07-12-2019     14:38         128512 loadperf.dll
-a----        15-07-2024     15:47         819432 locale.nls
-a----        15-07-2024     15:48         548352 localsec.dll
-a----        15-07-2024     15:46        1275904 localspl.dll
-a----        15-07-2024     15:46          19968 localui.dll
-a----        15-07-2024     15:48         409088 LocationApi.dll
-a----        15-07-2024     15:47        2033152 LocationFramework.dll
-a----        15-07-2024     15:47          83456 LocationFrameworkInternalPS.dll
-a----        15-07-2024     15:47          41440 LocationFrameworkPS.dll
-a----        15-07-2024     15:48          71168 LocationNotificationWindows.exe
-a----        15-07-2024     15:48         119296 LocationWinPalMisc.dll
-a----        07-12-2019     14:38          11264 Locator.exe
-a----        15-07-2024     15:47         458240 LockAppBroker.dll
-a----        15-07-2024     15:47          94040 LockAppHost.exe
-a----        15-07-2024     15:47         676864 LockController.dll
-a----        15-07-2024     15:47         457216 LockHostingFramework.dll
-a----        15-07-2024     15:46         173568 LockScreenContent.dll
-a----        15-07-2024     15:46          46592 LockScreenContentHost.dll
-a----        17-11-2023     23:47          49720 LockScreenContentServer.exe
-a----        15-07-2024     15:47         433152 LockScreenData.dll
-a----        07-12-2019     14:38          52224 lodctr.exe
-a----        17-11-2023     23:50         112640 logagent.exe
-a----        07-12-2019     14:39          83968 loghours.dll
-a----        17-11-2023     23:49         120320 logman.exe
-a----        15-07-2024     15:47         267560 logoncli.dll
-a----        15-07-2024     15:47         872448 LogonController.dll
-a----        07-12-2019     14:38          13824 LogonUI.exe
-a----        17-11-2023     23:47        1253888 lpasvc.dll
-a----        15-07-2024     15:47           3072 lpk.dll
-a----        17-11-2023     23:48          41984 lpkinstall.exe
-a----        15-07-2024     15:47         745472 lpksetup.exe
-a----        17-11-2023     23:48          10240 lpksetupproxyserv.dll
-a----        15-07-2024     15:47          72704 lpremove.exe
-a----        15-07-2024     15:47         340888 LsaIso.exe
-a----        15-07-2024     15:47        1672192 lsasrv.dll
-a----        15-07-2024     15:47          60640 lsass.exe
-a----        15-07-2024     15:47         846848 lsm.dll
-a----        17-11-2023     23:49          47616 lsmproxy.dll
-a----        17-11-2023     23:47          71144 luainstall.dll
-a----        07-12-2019     14:38          35840 luiapi.dll
-a----        07-12-2019     14:38         144998 lusrmgr.msc
-a----        07-12-2019     14:38           3072 lz32.dll
-a----        07-12-2019     14:38           9926 l_intl.nls
-a----        07-12-2019     14:38          52736 Magnification.dll
-a----        15-07-2024     15:47         650752 Magnify.exe
-a----        15-07-2024     15:47          75776 main.cpl
-a----        15-07-2024     15:47         117248 MaintenanceUI.dll
-a----        29-10-2023     08:36          86528 makecab.exe
-a----        07-12-2019     15:22         227328 manage-bde.exe
-a----        15-07-2024     15:46         233984 ManageCI.dll
-a----        15-07-2024     15:47         542208 MapConfiguration.dll
-a----        15-07-2024     15:47         230400 MapControlCore.dll
-a----        07-12-2019     14:38           2560 MapControlStringsRes.dll
-a----        15-07-2024     15:47        2632704 MapGeocoder.dll
-a----        15-07-2024     15:47         154112 mapi32.dll
-a----        15-07-2024     15:47         154112 mapistub.dll
-a----        15-07-2024     15:47        3182080 MapRouter.dll
-a----        15-07-2024     15:47         130048 MapsBtSvc.dll
-a----        07-12-2019     14:38          15360 MapsBtSvcProxy.dll
-a----        15-07-2024     15:47          98816 MapsCSP.dll
-a----        15-07-2024     15:47        1132544 MapsStore.dll
-a----        15-07-2024     15:47          54272 mapstoasttask.dll
-a----        15-07-2024     15:47          45568 mapsupdatetask.dll
-a----        15-07-2024     15:47         916480 MbaeApi.dll
-a----        15-07-2024     15:47        1201152 MbaeApiPublic.dll
-a----        07-12-2019     14:39         119296 MbaeParserTask.exe
-a----        07-12-2019     14:39          51712 MbaeXmlParser.dll
-a----        15-07-2024     15:48         808960 mblctr.exe
-a----        15-07-2024     15:47         746496 MBMediaManager.dll
-a----        15-07-2024     15:48        1178112 MBR2GPT.EXE
-a----        15-07-2024     15:47         686592 mbsmsapi.dll
-a----        15-07-2024     15:47          89600 mbussdapi.dll
-a----        07-12-2019     14:38          94208 mcbuilder.exe
-a----        15-07-2024     15:49         177664 MCCSEngineShared.dll
-a----        06-12-2019     22:05          31744 MCCSPal.dll
-a----        07-12-2019     14:39         103936 mciavi32.dll
-a----        07-12-2019     14:38          50176 mcicda.dll
-a----        07-12-2019     14:39          44032 mciqtz32.dll
-a----        07-12-2019     14:38          31232 mciseq.dll
-a----        07-12-2019     14:38          31744 mciwave.dll
-a----        17-11-2023     23:49          24576 McpManagementProxy.dll
-a----        15-07-2024     15:48         258048 McpManagementService.dll
-a----        15-07-2024     15:48        1091072 MCRecvSrc.dll
-a----        07-12-2019     14:38         110096 mcupdate_AuthenticAMD.dll
-a----        07-12-2019     14:38        2629648 mcupdate_GenuineIntel.dll
-a----        17-11-2023     23:50         454656 MDEServer.exe
-a----        15-07-2024     15:46         172544 MDMAgent.exe
-a----        15-07-2024     15:48         174592 MDMAppInstaller.exe
-a----        15-07-2024     15:46         182272 MdmCommon.dll
-a----        15-07-2024     15:47        2146304 MdmDiagnostics.dll
-a----        15-07-2024     15:47          52736 MdmDiagnosticsTool.exe
-a----        07-12-2019     14:39          79360 mdminst.dll
-a----        15-07-2024     15:47          81920 mdmlocalmanagement.dll
-a----        15-07-2024     15:47         181248 mdmmigrator.dll
-a----        15-07-2024     15:47          51200 mdmpostprocessevaluator.dll
-a----        15-07-2024     15:47         425472 mdmregistration.dll
-a----        07-12-2019     14:39          87040 MdRes.exe
-a----        07-12-2019     14:39          92672 MdSched.exe
-a----        15-07-2024     15:47         134656 MediaFoundation.DefaultPerceptionProvider.dll
-a----        07-12-2019     14:38           1284 MediaSystemToastIcon.contrast-white.png
-a----        07-12-2019     14:38            854 MediaSystemToastIcon.png
-a----        07-12-2019     14:38         110036 MediumRoom.bin
-a----        22-03-2024     13:02          33792 MemoryDiagnostic.dll
-a----        15-07-2024     15:47        1077760 MessagingDataModel2.dll
-a----        15-07-2024     15:46          91648 MessagingService.dll
-a----        15-07-2024     15:49         532704 mf.dll
-a----        17-11-2023     23:48          64512 mf3216.dll
-a----        07-12-2019     15:22         142168 mfAACEnc.dll
-a----        15-07-2024     15:49        1957624 mfasfsrcsnk.dll
-a----        17-11-2023     23:50         155648 mfaudiocnv.dll
-a----        19-01-2024     20:38        5631056 mfc140.dll
-a----        19-01-2024     20:38          51280 mfc140chs.dll
-a----        19-01-2024     20:38          51280 mfc140cht.dll
-a----        19-01-2024     20:38          79976 mfc140deu.dll
-a----        19-01-2024     20:38          70224 mfc140enu.dll
-a----        19-01-2024     20:38          78928 mfc140esn.dll
-a----        19-01-2024     20:38          79952 mfc140fra.dll
-a----        19-01-2024     20:38          77928 mfc140ita.dll
-a----        19-01-2024     20:38          58960 mfc140jpn.dll
-a----        19-01-2024     20:38          58448 mfc140kor.dll
-a----        19-01-2024     20:38          75880 mfc140rus.dll
-a----        19-01-2024     20:38        5665360 mfc140u.dll
-a----        29-10-2023     08:36        1456640 mfc42.dll
-a----        29-10-2023     08:36        1468928 mfc42u.dll
-a----        15-07-2024     15:49         678272 MFCaptureEngine.dll
-a----        19-01-2024     20:38          96880 mfcm140.dll
-a----        19-01-2024     20:38          96848 mfcm140u.dll
-a----        15-07-2024     15:49        4798976 mfcore.dll
-a----        07-12-2019     14:38          36864 mfcsubs.dll
-a----        17-11-2023     23:50         963416 mfds.dll
-a----        07-12-2019     15:22         148992 mfdvdec.dll
-a----        07-12-2019     15:22          70656 mferror.dll
-a----        07-12-2019     15:22          53248 mfh263enc.dll
-a----        17-11-2023     23:50         581120 mfh264enc.dll
-a----        07-12-2019     14:39         292864 mfksproxy.dll
-a----        15-07-2024     15:49        4310016 MFMediaEngine.dll
-a----        17-11-2023     23:50         100864 mfmjpegdec.dll
-a----        15-07-2024     15:49        1252864 mfmkvsrcsnk.dll
-a----        15-07-2024     15:49        2120296 mfmp4srcsnk.dll
-a----        15-07-2024     15:49        1354384 mfmpeg2srcsnk.dll
-a----        15-07-2024     15:49        1227352 mfnetcore.dll
-a----        15-07-2024     15:49        1817608 mfnetsrc.dll
-a----        07-12-2019     15:22        1233600 mfperfhelper.dll
-a----        15-07-2024     15:49        1815128 mfplat.dll
-a----        15-07-2024     15:49         585744 MFPlay.dll
-a----        07-12-2019     15:22          47504 mfpmp.exe
-a----        17-11-2023     23:50         268168 mfps.dll
-a----        17-11-2023     23:50        1088808 mfreadwrite.dll
-a----        15-07-2024     15:48         415288 mfsensorgroup.dll
-a----        15-07-2024     15:49        2206528 mfsrcsnk.dll
-a----        15-07-2024     15:49        1533616 mfsvr.dll
-a----        07-12-2019     15:22         352768 mftranscode.dll
-a----        17-11-2023     23:50          99816 mfvdsp.dll
-a----        07-12-2019     15:22          46080 mfvfw.dll
-a----        07-12-2019     15:22         466944 MFWMAAEC.DLL
-a----        02-08-2021     19:21       26737472 mfxplugin64_hw.dll
-a----        07-12-2019     14:38          24576 mgmtapi.dll
-a----        15-07-2024     15:49         119296 mgmtrefreshcredprov.dll
-a----        17-11-2023     23:48         127488 mi.dll
-a----        07-12-2019     14:38          91136 mibincodec.dll
-a----        07-12-2019     14:38         212992 Microsoft-Windows-AppModelExecEvents.dll
-a----        07-12-2019     14:39          21304 microsoft-windows-battery-events.dll
-a----        07-12-2019     14:39          15672 microsoft-windows-hal-events.dll
-a----        15-07-2024     15:46         188416 Microsoft-Windows-Internal-Shell-NearShareExperience.dll
-a----        07-12-2019     14:39          54800 microsoft-windows-kernel-pnp-events.dll
-a----        07-12-2019     14:39         323384 microsoft-windows-kernel-power-events.dll
-a----        07-12-2019     14:39         175112 microsoft-windows-kernel-processor-power-events.dll
-a----        07-12-2019     14:38         113664 Microsoft-Windows-MapControls.dll
-a----        07-12-2019     14:38           8192 Microsoft-Windows-MosHost.dll
-a----        07-12-2019     14:39          82232 microsoft-windows-pdc.dll
-a----        07-12-2019     14:38          10240 microsoft-windows-power-cad-events.dll
-a----        07-12-2019     14:39           4096 microsoft-windows-processor-aggregator-events.dll
-a----        07-12-2019     14:39          17424 microsoft-windows-sleepstudy-events.dll
-a----        07-12-2019     14:38           6144 microsoft-windows-storage-tiering-events.dll
-a----        15-07-2024     15:47         501640 microsoft-windows-system-events.dll
-a----        07-12-2019     14:38           2560 Microsoft-WindowsPhone-SEManagementProvider.dll
-a----        15-07-2024     15:47         297984 Microsoft.Bluetooth.Proxy.dll
-a----        15-07-2024     15:47        3769856 Microsoft.Bluetooth.Service.dll
-a----        15-07-2024     15:46         501248 Microsoft.Bluetooth.UserService.dll
-a----        15-07-2024     15:48        1191936 Microsoft.Graphics.Display.DisplayEnhancementService.dll
-a----        15-07-2024     15:46         110592 Microsoft.LocalUserImageProvider.dll
-a----        17-11-2023     23:50          18432 Microsoft.Management.Infrastructure.Native.Unmanaged.dll
-a----        15-07-2024     15:46         741376 MicrosoftAccount.TokenProvider.Core.dll
-a----        15-07-2024     15:46         281600 MicrosoftAccountCloudAP.dll
-a----        15-07-2024     15:46         441344 MicrosoftAccountExtension.dll
-a----        15-07-2024     15:46         296448 MicrosoftAccountTokenProvider.dll
-a----        15-07-2024     15:46         555008 MicrosoftAccountWAMExtension.dll
-a----        15-07-2024     15:46          97280 MicrosoftEdgeBCHost.exe
-a----        15-07-2024     15:47          97280 MicrosoftEdgeCP.exe
-a----        15-07-2024     15:46          97280 MicrosoftEdgeDevTools.exe
-a----        15-07-2024     15:47          58880 MicrosoftEdgeSH.exe
-a----        17-11-2023     23:47          27136 midimap.dll
-a----        17-11-2023     23:49         146288 migisol.dll
-a----        07-12-2019     14:39         183808 miguiresource.dll
-a----        07-12-2019     14:39          40448 mimefilt.dll
-a----        07-12-2019     14:38         158208 mimofcodec.dll
-a----        07-12-2019     14:38          17408 MinstoreEvents.dll
-a----        17-11-2023     23:48          37376 MiracastInputMgr.dll
-a----        15-07-2024     15:46        1263104 MiracastReceiver.dll
-a----        15-07-2024     15:48          91136 MiracastReceiverExt.dll
-a----        07-12-2019     14:39          38912 MirrorDrvCompat.dll
-a----        15-07-2024     15:48        3171200 mispace.dll
-a----        15-07-2024     15:46         512512 MitigationClient.dll
-a----        15-07-2024     15:47          86528 MitigationConfiguration.dll
-a----        17-11-2023     23:48         245248 miutils.dll
-a----        15-07-2024     15:49         422400 MixedReality.Broker.dll
-a----        15-07-2024     15:49         567296 MixedRealityCapture.Pipeline.dll
-a----        15-07-2024     15:49         135944 MixedRealityRuntime.dll
-a----        07-12-2019     14:40            112 MixedRealityRuntime.json
-a----        07-12-2019     14:39         673088 mlang.dat
-a----        17-11-2023     23:48         249856 mlang.dll
-a----        15-07-2024     15:48        1954304 mmc.exe
-a----        07-12-2019     14:42           3103 mmc.exe.config
-a----        17-11-2023     23:49         186368 mmcbase.dll
-a----        17-11-2023     23:49        2415104 mmcndmgr.dll
-a----        17-11-2023     23:49         136192 mmcshext.dll
-a----        15-07-2024     15:46         530616 MMDevAPI.dll
-a----        15-07-2024     15:47        1700864 mmgaclient.dll
-a----        07-12-2019     14:38         155136 mmgaproxystub.dll
-a----        15-07-2024     15:47        1288704 mmgaserver.exe
-a----        07-12-2019     14:38           3584 mmres.dll
-a----        15-07-2024     15:47         544256 mmsys.cpl
-a----        17-11-2023     23:48          21504 mobilenetworking.dll
-a----        15-07-2024     15:48          99328 mobsync.exe
-a----        17-11-2023     23:49          33280 mode.com
-a----        07-12-2019     14:39         192512 modemui.dll
-a----        15-07-2024     15:46         488448 modernexecserver.dll
-a----        07-12-2019     14:39          29696 more.com
-a----        07-12-2019     14:39           2560 moricons.dll
-a----        15-07-2024     15:47          94720 moshost.dll
-a----        17-11-2023     23:48          93696 MosHostClient.dll
-a----        15-07-2024     15:47         235496 moshostcore.dll
-a----        15-07-2024     15:47          88576 MosStorage.dll
-a----        07-12-2019     14:39          18944 mountvol.exe
-a----        07-12-2019     14:38           1386 MouseSystemToastIcon.contrast-white.png
-a----        07-12-2019     14:38           1087 MouseSystemToastIcon.png
-a----        15-07-2024     15:47        1789952 MoUsoCoreWorker.exe
-a----        07-12-2019     15:22         105048 MP3DMOD.DLL
-a----        17-11-2023     23:50         241376 MP43DECD.DLL
-a----        17-11-2023     23:50         363144 MP4SDECD.DLL
-a----        07-12-2019     14:39         103936 Mpeg2Data.ax
-a----        07-12-2019     14:39         235520 mpeval.dll
-a----        17-11-2023     23:49         266240 mpg2splt.ax
-a----        17-11-2023     23:50         241888 MPG4DECD.DLL
-a----        07-12-2019     14:38          19968 mpnotify.exe
-a----        17-11-2023     23:48         110688 mpr.dll
-a----        15-07-2024     15:47         532992 mprapi.dll
-a----        15-07-2024     15:47         920064 mprddm.dll
-a----        15-07-2024     15:47         552448 mprdim.dll
-a----        07-12-2019     14:39          13824 mprext.dll
-a----        17-11-2023     23:49         115200 mprmsg.dll
------        18-01-2024     23:11         918944 MpSigStub.exe
-a----        15-07-2024     15:47        1174016 MPSSVC.dll
-a----        07-12-2019     14:39         495104 mpunits.dll
-a----        07-12-2019     14:39          17408 MRINFO.EXE
-a----        15-07-2024     15:47        1016056 MrmCoreR.dll
-a----        15-07-2024     15:47         328520 MrmDeploy.dll
-a----        15-07-2024     15:47         820224 MrmIndexer.dll
-a----        15-07-2024     15:33      194135240 MRT.exe
-a----        07-12-2019     14:38          31904 mrt100.dll
-a----        07-12-2019     14:38          33440 mrt_map.dll
-a----        15-07-2024     15:47          58368 ms3dthumbnailprovider.dll
-a----        17-11-2023     23:49         170496 msaatext.dll
-a----        07-12-2019     15:22         243200 MSAC3ENC.DLL
-a----        07-12-2019     14:38         112080 msacm32.dll
-a----        17-11-2023     23:47          30208 msacm32.drv
-a----        17-11-2023     23:47          36720 msadp32.acm
-a----        07-12-2019     14:38           3072 msafd.dll
-a----        15-07-2024     15:46        3001856 MSAJApi.dll
-a----        17-11-2023     23:50          58368 MSAlacDecoder.dll
-a----        17-11-2023     23:50          76800 MSAlacEncoder.dll
-a----        07-12-2019     15:22         140800 MSAMRNBDecoder.dll
-a----        07-12-2019     15:22         217088 MSAMRNBEncoder.dll
-a----        07-12-2019     15:22          38400 MSAMRNBSink.dll
-a----        07-12-2019     15:22         101376 MSAMRNBSource.dll
-a----        20-01-2024     11:02          55296 MSAProfileNotificationHandler.dll
-a----        17-11-2023     23:48          65248 msasn1.dll
-a----        15-07-2024     15:49         424320 MSAudDecMFT.dll
-a----        17-11-2023     23:48         155648 msaudite.dll
-a----        20-01-2024     11:02          24064 msauserext.dll
-a----        07-12-2019     14:39         315392 mscandui.dll
-a----        07-12-2019     14:38          11776 mscat32.dll
-a----        07-12-2019     14:38          83968 MSchedExe.exe
-a----        17-11-2023     23:53         232448 msclmd.dll
-a----        15-07-2024     15:47         710184 mscms.dll
-a----        17-11-2023     23:49         197632 msconfig.exe
-a----        07-12-2019     14:40         383488 mscoree.dll
-a----        07-12-2019     14:40          19968 mscorier.dll
-a----        07-12-2019     14:40          76360 mscories.dll
-a----        15-07-2024     15:47        1125064 msctf.dll
-a----        07-12-2019     14:39          10752 msctfime.ime
-a----        15-07-2024     15:47          94208 MsCtfMonitor.dll
-a----        17-11-2023     23:49         219136 msctfp.dll
-a----        07-12-2019     14:39         126976 msctfui.dll
-a----        15-07-2024     15:47         799744 msctfuimanager.dll
-a----        07-12-2019     14:39         160256 msdadiag.dll
-a----        07-12-2019     14:38         137728 msdart.dll
-a----        07-12-2019     14:39           5120 msdatsrc.tlb
-a----        17-11-2023     23:48         559072 msdelta.dll
-a----        07-12-2019     14:38          34600 msdmo.dll
-a----        07-12-2019     14:38         570368 msdrm.dll
-a----        15-07-2024     15:48         498176 msdt.exe
-a----        15-07-2024     15:48         182784 msdtc.exe
-a----        15-07-2024     15:48         408064 msdtckrm.dll
-a----        15-07-2024     15:48         162816 msdtclog.dll
-a----        15-07-2024     15:48         922624 msdtcprx.dll
-a----        15-07-2024     15:48          15872 msdtcspoffln.dll
-a----        15-07-2024     15:48        1658368 msdtctm.dll
-a----        15-07-2024     15:48         372224 msdtcuiu.dll
-a----        07-12-2019     14:38          22528 msdtcVSp1res.dll
-a----        07-12-2019     14:39          79872 MSDvbNP.ax
-a----        17-11-2023     23:50           7168 msdxm.ocx
-a----        07-12-2019     01:25          44032 msdxm.tlb
-a----        15-07-2024     15:48         791552 msfeeds.dll
-a----        15-07-2024     15:48          76800 msfeedsbs.dll
-a----        07-12-2019     14:39          14848 msfeedssync.exe
-a----        15-07-2024     15:49         464896 MSFlacDecoder.dll
-a----        15-07-2024     15:49         294400 MSFlacEncoder.dll
-a----        15-07-2024     15:46        3423744 msftedit.dll
-a----        15-07-2024     15:47          57344 MsftOemDllIgneous.dll
-a----        17-11-2023     23:47          27008 msg711.acm
-a----        17-11-2023     23:47          44096 msgsm32.acm
-a----        17-11-2023     23:50          36864 MSHEIF.dll
-a----        15-07-2024     15:48          43520 mshta.exe
-a----        15-07-2024     15:48       23450624 mshtml.dll
-a----        15-07-2024     15:48        2755584 mshtml.tlb
-a----        07-12-2019     14:39          83968 MshtmlDac.dll
-a----        17-11-2023     23:49         102912 mshtmled.dll
-a----        07-12-2019     14:39          49152 mshtmler.dll
-a----        15-07-2024     15:48        3339776 msi.dll
-a----        07-12-2019     14:39          46080 MsiCofire.dll
-a----        17-11-2023     23:48          15872 msidcrl40.dll
-a----        07-12-2019     14:38          67072 msident.dll
-a----        07-12-2019     14:38          11776 msidle.dll
-a----        07-12-2019     14:38           5120 msidntld.dll
-a----        15-07-2024     15:46         280064 msieftp.dll
-a----        15-07-2024     15:48          69632 msiexec.exe
-a----        07-12-2019     14:39         412672 msihnd.dll
-a----        07-12-2019     14:39          22528 msiltcfg.dll
-a----        17-11-2023     23:48           8192 msimg32.dll
-a----        15-07-2024     15:48          26112 msimsg.dll
-a----        07-12-2019     14:39          51712 msimtf.dll
-a----        17-11-2023     23:49         386048 msinfo32.exe
-a----        15-07-2024     15:48          70656 msisip.dll
-a----        15-07-2024     15:47         333824 msIso.dll
-a----        07-12-2019     14:39          12288 msiwer.dll
-a----        15-07-2024     15:46         194560 mskeyprotcli.dll
-a----        17-11-2023     23:48          66560 mskeyprotect.dll
-a----        29-10-2023     08:36         215552 msls31.dll
-a----        15-07-2024     15:49        1069352 msmpeg2adec.dll
-a----        15-07-2024     15:49         944128 MSMPEG2ENC.DLL
-a----        15-07-2024     15:49        2521144 msmpeg2vdec.dll
-a----        07-12-2019     14:39         260096 MSNP.ax
-a----        17-11-2023     23:48          63488 msobjs.dll
-a----        17-11-2023     23:49         118784 msoert2.dll
-a----        17-11-2023     23:50         166912 MSOpusDecoder.dll
-a----        15-07-2024     15:49         938496 mspaint.exe
-a----        17-11-2023     23:48          57304 mspatcha.dll
-a----        29-10-2023     08:36          84480 mspatchc.dll
-a----        17-11-2023     23:50        1669632 MSPhotography.dll
-a----        07-12-2019     14:39          60416 msports.dll
-a----        07-12-2019     14:38           2560 msprivs.dll
-a----        17-11-2023     23:50         592896 msra.exe
-a----        17-11-2023     23:50         137216 msrahc.dll
-a----        17-11-2023     23:50           7680 MsraLegacy.tlb
-a----        07-12-2019     14:38          12288 msrating.dll
-a----        17-11-2023     23:50          36864 MSRAWImage.dll
-a----        17-11-2023     23:49         185856 msrdc.dll
-a----        17-11-2023     23:49          63488 MsRdpWebAccess.dll
-a----        07-12-2019     14:39          18432 msrle32.dll
-a----        15-07-2024     15:47          66048 msscntrs.dll
-a----        07-12-2019     14:38          80896 mssign32.dll
-a----        07-12-2019     14:38          10240 mssip32.dll
-a----        15-07-2024     15:47         131072 mssitlb.dll
-a----        15-07-2024     15:49         938496 MsSpellCheckingFacility.dll
-a----        17-11-2023     23:50          84480 MsSpellCheckingHost.exe
-a----        15-07-2024     15:47         214528 mssph.dll
-a----        15-07-2024     15:47         145920 mssprxy.dll
-a----        15-07-2024     15:47        2980352 mssrch.dll
-a----        15-07-2024     15:47         381952 mssvp.dll
-a----        07-12-2019     14:39         147456 mstask.dll
-a----        15-07-2024     15:48         486912 msTextPrediction.dll
-a----        15-07-2024     15:49        1297408 mstsc.exe
-a----        15-07-2024     15:48        8380416 mstscax.dll
-a----        17-11-2023     23:49         262144 msutb.dll
-a----        15-07-2024     15:47         545152 msv1_0.dll
-a----        07-12-2019     14:38          83968 msvcirt.dll
-a----        02-02-2002     08:32         608080 msvcp100.dll
-a----        17-11-2023     23:47         561568 msvcp110_win.dll
-a----        07-12-2019     14:40         690008 msvcp120_clr0400.dll
-a----        01-02-2002     19:02         573008 msvcp140.dll
-a----        01-02-2002     19:02          35920 msvcp140_1.dll
-a----        01-02-2002     19:02         268392 msvcp140_2.dll
-a----        01-02-2002     19:02          50280 msvcp140_atomic_wait.dll
-a----        25-06-2022     03:01         571280 msvcp140_clr0400.dll
-a----        01-02-2002     19:02          31856 msvcp140_codecvt_ids.dll
-a----        07-12-2019     14:38         611840 msvcp60.dll
-a----        17-11-2023     23:48         635952 msvcp_win.dll
-a----        02-02-2002     08:32         829264 msvcr100.dll
-a----        25-06-2022     07:46          12688 msvcr100_clr0400.dll
-a----        07-12-2019     14:40         993632 msvcr120_clr0400.dll
-a----        17-11-2023     23:48         638552 msvcrt.dll
-a----        07-12-2019     14:39         152064 msvfw32.dll
-a----        07-12-2019     14:39          39936 msvidc32.dll
-a----        17-11-2023     23:49        3452416 MSVidCtl.dll
-a----        17-11-2023     23:50         724784 MSVideoDSP.dll
-a----        17-11-2023     23:50          44456 MSVP9DEC.dll
-a----        15-07-2024     15:49        1440016 msvproc.dll
-a----        17-11-2023     23:50          44472 MSVPXENC.dll
-a----        17-11-2023     23:48         260464 MSWB7.dll
-a----        17-11-2023     23:50          35328 MSWebp.dll
-a----        17-11-2023     23:50         428544 mswmdm.dll
-a----        17-11-2023     23:48         419584 mswsock.dll
-a----        15-07-2024     15:47        1696256 msxml3.dll
-a----        17-11-2023     23:48           2560 msxml3r.dll
-a----        15-07-2024     15:46        2474760 msxml6.dll
-a----        17-11-2023     23:48           2560 msxml6r.dll
-a----        07-12-2019     14:39          27648 msyuv.dll
-a----        15-07-2024     15:47         221184 MtcModel.dll
-a----        15-07-2024     15:47         284144 MTF.dll
-a----        15-07-2024     15:46         103936 MTFAppServiceDS.dll
-a----        15-07-2024     15:46         319488 MtfDecoder.dll
-a----        15-07-2024     15:46         176640 MTFFuzzyDS.dll
-a----        15-07-2024     15:47         282112 MTFServer.dll
-a----        15-07-2024     15:46         115200 MTFSpellcheckDS.dll
-a----        07-12-2019     14:38         137216 mtstocom.exe
-a----        15-07-2024     15:48         474624 mtxclu.dll
-a----        07-12-2019     14:38          31744 mtxdm.dll
-a----        07-12-2019     14:38           9728 mtxex.dll
-a----        15-07-2024     15:48         180224 mtxoci.dll
-a----        07-12-2019     14:38          18944 muifontsetup.dll
-a----        17-11-2023     23:48          16896 MUILanguageCleanup.dll
-a----        15-07-2024     15:47         107008 MuiUnattend.exe
-a----        07-12-2019     14:39          54784 MultiDigiMon.exe
-a----        15-07-2024     15:47         186880 musdialoghandlers.dll
-a----        15-07-2024     15:47         695296 MusNotification.exe
-a----        15-07-2024     15:47         632320 MusNotificationUx.exe
-a----        15-07-2024     15:47         648872 MusNotifyIcon.exe
-a----        15-07-2024     15:47        1182720 MusUpdateHandlers.dll
-a----        17-11-2023     23:49         131584 mycomput.dll
-a----        15-07-2024     15:47          50688 mydocs.dll
-a----        15-07-2024     15:48         155136 Mystify.scr
-a----        17-11-2023     23:49          50688 NAPCRYPT.DLL
-a----        17-11-2023     23:48          70144 NapiNSP.dll
-a----        15-07-2024     15:47         534016 Narrator.exe
-a----        07-12-2019     14:38          30811 NarratorControlTemplates.xml
-a----        15-07-2024     15:46         454656 NaturalAuth.dll
-a----        07-12-2019     14:38          22528 NaturalAuthClient.dll
-a----        15-07-2024     15:46        1071104 NaturalLanguage6.dll
-a----        15-07-2024     15:47          41472 navshutdown.dll
-a----        07-12-2019     14:39          22016 nbtstat.exe
-a----        07-12-2019     14:38          25600 NcaApi.dll
-a----        07-12-2019     14:38         171520 NcaSvc.dll
-a----        17-11-2023     23:48         382464 ncbservice.dll
-a----        15-07-2024     15:49          92672 NcdAutoSetup.dll
-a----        07-12-2019     14:39          26112 NcdProp.dll
-a----        15-07-2024     15:47          47104 nci.dll
-a----        15-07-2024     15:46          75264 ncobjapi.dll
-a----        17-11-2023     23:49         102912 ncpa.cpl
-a----        15-07-2024     15:47         160168 ncrypt.dll
-a----        15-07-2024     15:47         354816 ncryptprov.dll
-a----        17-11-2023     23:48         139608 ncryptsslp.dll
-a----        15-07-2024     15:47         528896 ncsi.dll
-a----        07-12-2019     14:39          30720 ncuprov.dll
-a----        29-10-2023     08:36          69632 ndadmin.exe
-a----        07-12-2019     14:39          12288 nddeapi.dll
-a----        17-11-2023     23:49         280064 ndfapi.dll
-a----        17-11-2023     23:49          45568 ndfetw.dll
-a----        07-12-2019     14:39            565 NdfEventView.xml
-a----        17-11-2023     23:49         119296 ndfhcdiscovery.dll
-a----        17-11-2023     23:49         100352 ndishc.dll
-a----        07-12-2019     14:39          32272 NDKPing.exe
-a----        07-12-2019     14:39          32768 ndproxystub.dll
-a----        15-07-2024     15:48         132608 nduprov.dll
-a----        15-07-2024     15:46         147968 negoexts.dll
-a----        07-12-2019     14:39          59904 net.exe
-a----        17-11-2023     23:49         183808 net1.exe
-a----        17-11-2023     23:48          89024 netapi32.dll
-a----        07-12-2019     14:39          18944 netbios.dll
-a----        17-11-2023     23:49          27136 netbtugc.exe
-a----        07-12-2019     14:39          69632 NetCellcoreCellManagerProviderResources.dll
-a----        15-07-2024     15:48         248320 netcenter.dll
-a----        07-12-2019     14:38          37376 netcfg.exe
-a----        15-07-2024     15:47          76288 NetCfgNotifyObjectHost.exe
-a----        15-07-2024     15:47         105968 netcfgx.dll
-a----        15-07-2024     15:48         475648 netcorehc.dll
-a----        15-07-2024     15:48         325632 netdiagfx.dll
-a----        15-07-2024     15:47         113664 NetDriverInstall.dll
-a----        07-12-2019     14:38          20480 netevent.dll
-a----        07-12-2019     14:39          35328 NetEvtFwdr.exe
-a----        07-12-2019     14:40         107520 netfxperf.dll
-a----        07-12-2019     14:39           2560 neth.dll
-a----        07-12-2019     14:39          10752 NetHost.exe
-a----        15-07-2024     15:47         203264 netid.dll
-a----        17-11-2023     23:49         196096 netiohlp.dll
-a----        17-11-2023     23:49          31744 netiougc.exe
-a----        23-02-2024     23:41         192512 netjoin.dll
-a----        15-07-2024     15:47         910848 netlogon.dll
-a----        17-11-2023     23:47         288768 netman.dll
-a----        15-07-2024     15:49         223712 NetMgmtIF.dll
-a----        15-07-2024     15:47           2560 netmsg.dll
-a----        15-07-2024     15:47         326144 netplwiz.dll
-a----        15-07-2024     15:47          40960 Netplwiz.exe
-a----        15-07-2024     15:47         231936 netprofm.dll
-a----        15-07-2024     15:47        1005568 netprofmsvc.dll
-a----        17-11-2023     23:49          68096 netprovfw.dll
-a----        17-11-2023     23:49          71680 netprovisionsp.dll
-a----        15-07-2024     15:47         147336 NetSetupApi.dll
-a----        15-07-2024     15:47         810352 NetSetupEngine.dll
-a----        15-07-2024     15:47         470016 NetSetupShim.dll
-a----        15-07-2024     15:47         329216 NetSetupSvc.dll
-a----        07-12-2019     14:39          96768 netsh.exe
-a----        15-07-2024     15:47         568832 netshell.dll
-a----        07-12-2019     14:39          39936 NETSTAT.EXE
-a----        15-07-2024     15:48         402944 nettrace.dll
-a----        07-12-2019     14:39          21656 NetTrace.PLA.Diagnostics.xml
-a----        29-10-2023     08:37          73216 nettraceex.dll
-a----        17-11-2023     23:48          43000 netutils.dll
-a----        15-07-2024     15:47         347000 NetworkBindingEngineMigPlugin.dll
-a----        17-11-2023     23:49         604672 NetworkCollectionAgent.dll
-a----        15-07-2024     15:47         205312 NetworkDesktopSettings.dll
-a----        15-07-2024     15:47          80896 networkexplorer.dll
-a----        15-07-2024     15:49         128000 networkhelper.dll
-a----        15-07-2024     15:46         170496 NetworkIcon.dll
-a----        07-12-2019     14:38          56320 networkitemfactory.dll
-a----        15-07-2024     15:47        3143168 NetworkMobileSettings.dll
-a----        07-12-2019     14:38          29184 NetworkProxyCsp.dll
-a----        15-07-2024     15:47         110080 NetworkQoSPolicyCSP.dll
-a----        15-07-2024     15:47         128000 NetworkStatus.dll
-a----        15-07-2024     15:47         427520 NetworkUXBroker.dll
-a----        15-07-2024     15:47         312832 newdev.dll
-a----        29-10-2023     08:36          72192 newdev.exe
-a----        15-07-2024     15:46         107008 NFCProvisioningPlugin.dll
-a----        17-11-2023     23:48          55296 NfcRadioMedia.dll
-a----        15-07-2024     15:46         680960 ngccredprov.dll
-a----        15-07-2024     15:46         567808 NgcCtnr.dll
-a----        15-07-2024     15:47         460800 NgcCtnrGidsHandler.dll
-a----        15-07-2024     15:46         790528 NgcCtnrSvc.dll
-a----        15-07-2024     15:48         475856 NgcIso.exe
-a----        15-07-2024     15:48         695296 NgcIsoCtnr.dll
-a----        15-07-2024     15:46         205824 ngckeyenum.dll
-a----        15-07-2024     15:46         133632 ngcksp.dll
-a----        15-07-2024     15:47          74752 ngclocal.dll
-a----        15-07-2024     15:46         273920 ngcpopkeysrv.dll
-a----        15-07-2024     15:46         172544 NgcProCsp.dll
-a----        15-07-2024     15:46         284160 ngcrecovery.dll
-a----        15-07-2024     15:46         948224 ngcsvc.dll
-a----        15-07-2024     15:47         279040 ngctasks.dll
-a----        09-08-2024     15:40              0 nginx-deployment.yaml
-a----        15-07-2024     15:47         409088 ninput.dll
-a----        22-03-2024     13:02          97280 nlaapi.dll
-a----        17-11-2023     23:49          96256 nlahc.dll
-a----        22-03-2024     13:02         388608 nlasvc.dll
-a----        15-07-2024     15:47         195072 nlhtml.dll
-a----        17-11-2023     23:49         176128 nlmgp.dll
-a----        15-07-2024     15:47          33792 nlmproxy.dll
-a----        15-07-2024     15:47          20480 nlmsprep.dll
-a----        15-07-2024     15:47          91520 nlsbres.dll
-a----        07-12-2019     14:39        1579008 NlsData0000.dll
-a----        06-12-2019     21:56        6361600 NlsData0009.dll
-a----        07-12-2019     14:38          10752 Nlsdl.dll
-a----        06-12-2019     22:06        2629120 NlsLexicons0009.dll
-a----        17-11-2023     23:49         541184 nltest.exe
-a----        15-07-2024     15:47         259584 NmaDirect.dll
-a----        15-07-2024     15:49         143856 nmbind.exe
-a----        15-07-2024     15:49         152448 nmscrub.exe
-a----        07-12-2019     14:42            741 NOISE.DAT
-a----        17-11-2023     23:48           6144 normaliz.dll
-a----        07-12-2019     14:38          81870 normidna.nls
-a----        07-12-2019     14:38          57136 normnfc.nls
-a----        07-12-2019     14:38          50442 normnfd.nls
-a----        07-12-2019     14:38          79348 normnfkc.nls
-a----        07-12-2019     14:38          73114 normnfkd.nls
-a----        15-07-2024     15:49         200704 notepad.exe
-a----        15-07-2024     15:47        1229824 NotificationController.dll
-a----        15-07-2024     15:47         391680 NotificationControllerPS.dll
-a----        15-07-2024     15:47          46080 notificationplatformcomponent.dll
-a----        15-07-2024     15:47          49152 npmproxy.dll
-a----        15-07-2024     15:47         202240 NPSM.dll
-a----        15-07-2024     15:47         214016 NPSMDesktopProvider.dll
-a----        07-12-2019     14:38          19456 nrpsrv.dll
-a----        17-11-2023     23:49          52224 nshhttp.dll
-a----        17-11-2023     23:48         382464 nshipsec.dll
-a----        17-11-2023     23:49         789504 nshwfp.dll
-a----        17-11-2023     23:48          25976 nsi.dll
-a----        17-11-2023     23:48          34304 nsisvc.dll
-a----        07-12-2019     14:38          89600 nslookup.exe
-a----        17-11-2023     23:48         242328 ntasn1.dll
-a----        15-07-2024     15:47        2029080 ntdll.dll
-a----        17-11-2023     23:48         154112 ntdsapi.dll
-a----        15-07-2024     15:47         109056 ntlanman.dll
-a----        07-12-2019     14:39          20480 ntlanui2.dll
-a----        15-07-2024     15:47          70456 NtlmShared.dll
-a----        17-11-2023     23:48         192856 ntmarta.dll
-a----        15-07-2024     15:47       10872192 ntoskrnl.exe
-a----        15-07-2024     15:47         379904 ntprint.dll
-a----        17-11-2023     23:49          64000 ntprint.exe
-a----        15-07-2024     15:47         489472 ntshrui.dll
-a----        17-11-2023     23:48          19456 ntvdm64.dll
-a----        15-07-2024     15:49          42976 NvAgent.dll
-a----        15-07-2024     15:49         292728 nvspinfo.exe
-a----        15-07-2024     15:48         705024 objsel.dll
-a----        07-12-2019     14:39         153088 occache.dll
-a----        15-07-2024     15:47         202240 ocsetapi.dll
-a----        15-07-2024     15:48         757760 odbc32.dll
-a----        07-12-2019     14:39          74240 odbcad32.exe
-a----        07-12-2019     14:39          48128 odbcbcp.dll
-a----        17-11-2023     23:49          30720 odbcconf.dll
-a----        07-12-2019     14:39          27136 odbcconf.exe
-a----        07-12-2019     14:39            263 odbcconf.rsp
-a----        07-12-2019     14:39         134656 odbccp32.dll
-a----        07-12-2019     14:39          90112 odbccr32.dll
-a----        07-12-2019     14:39          90624 odbccu32.dll
-a----        07-12-2019     14:39         225280 odbcint.dll
-a----        07-12-2019     14:39         168960 odbctrac.dll
-a----        20-01-2024     11:04          23040 OEMDefaultAssociations.dll
-a----        13-03-2021     08:58          20611 OEMDefaultAssociations.xml
-a----        20-01-2024     11:02         134512 oemlicense.dll
-a----        17-11-2023     23:47          79872 ofdeploy.exe
-a----        07-12-2019     14:39         276480 offfilt.dll
-a----        17-11-2023     23:47         123392 officecsp.dll
-a----        15-07-2024     15:47         136168 offlinelsa.dll
-a----        15-07-2024     15:47         279008 offlinesam.dll
-a----        15-07-2024     15:48          90112 offreg.dll
-a----        07-12-2019     14:38          45568 oflc-nz.rs
-a----        07-12-2019     14:38            423 OkDone_80.contrast-black.png
-a----        07-12-2019     14:38            438 OkDone_80.contrast-white.png
-a----        07-12-2019     14:38            423 OkDone_80.png
-a----        15-07-2024     15:47        1217432 ole32.dll
-a----        17-11-2023     23:49         403968 oleacc.dll
-a----        17-11-2023     23:49          13312 oleacchooks.dll
-a----        07-12-2019     14:39           4608 oleaccrc.dll
-a----        17-11-2023     23:48         833136 oleaut32.dll
-a----        15-07-2024     15:47         210432 oledlg.dll
-a----        15-07-2024     15:46         152064 oleprn.dll
-a----        15-07-2024     15:46         230912 OmaDmAgent.dll
-a----        15-07-2024     15:47         225240 omadmapi.dll
-a----        15-07-2024     15:47         477184 omadmclient.exe
-a----        15-07-2024     15:47         121856 omadmprc.exe
-a----        17-11-2023     23:48          45568 OnDemandBrokerClient.dll
-a----        15-07-2024     15:46          73728 OnDemandConnRouteHelper.dll
-a----        15-07-2024     15:49         366080 OneBackupHandler.dll
-a----        15-07-2024     15:46         502272 OneCoreCommonProxyStub.dll
-a----        15-07-2024     15:46        8253328 OneCoreUAPCommonProxyStub.dll
-a----        15-07-2024     15:47         709632 OneDriveSettingSyncProvider.dll
-a----        15-07-2024     15:47         182784 OneSettingsClient.dll
-a----        17-11-2023     23:47         238080 onex.dll
-a----        07-12-2019     14:38         113152 onexui.dll
-a----        07-12-2019     14:38           2832 onnxruntime.dll
-a----        15-07-2024     15:46         102832 OOBE-Maintenance.exe
-a----        15-07-2024     15:47        2191360 OpcServices.dll
-a----        02-08-2021     19:21         507712 OpenCL.dll
-a----        07-12-2019     14:39          75776 openfiles.exe
-a----        15-07-2024     15:48        1073152 opengl32.dll
-a----        15-07-2024     15:47         126192 OpenWith.exe
-a----        12-10-2021     06:12         114880 Optane.dll
-a----        12-10-2021     06:12          24256 OptaneEventLogMsg.dll
-a----        15-07-2024     15:48         112640 OptionalFeatures.exe
-a----        21-04-2020     02:25        1032544 ortcengine.dll
-a----        07-12-2019     14:39          27136 osbaseln.dll
-a----        15-07-2024     15:47         674304 osk.exe
-a----        07-12-2019     14:38          10240 OskSupport.dll
-a----        07-12-2019     14:38           9728 osuninst.dll
-a----        07-12-2019     14:38          46920 OutdoorAudioEnvironment.bin
-a----        17-11-2023     23:49         219648 P2P.dll
-a----        07-12-2019     14:39         437760 P2PGraph.dll
-a----        07-12-2019     14:39         207360 p2pnetsh.dll
-a----        17-11-2023     23:49         439808 p2psvc.dll
-a----        15-07-2024     15:49         158192 p9np.dll
-a----        17-11-2023     23:48          12288 pacjsworker.exe
-a----        15-07-2024     15:47          40960 PackagedCWALauncher.exe
-a----        15-07-2024     15:48          96256 packager.dll
-a----        15-07-2024     15:46          66048 PackageStateChangeHandler.dll
-a----        15-07-2024     15:46         241152 PackageStateRoaming.dll
-a----        07-12-2019     14:38          14848 panmap.dll
-a----        15-07-2024     15:47         272384 PasswordEnrollmentManager.dll
-a----        15-07-2024     15:47          47016 PasswordOnWakeSettingFlyout.exe
-a----        07-12-2019     14:39          20480 PATHPING.EXE
-a----        07-12-2019     14:39          67072 pautoenr.dll
-a----        17-11-2023     23:49         973312 PayloadRestrictions.dll
-a----        07-12-2019     14:38          24576 PaymentMediatorServiceProxy.dll
-a----        15-07-2024     15:47         106496 pcacli.dll
-a----        15-07-2024     15:47         102400 pcadm.dll
-a----        17-11-2023     23:48          12800 pcaevts.dll
-a----        15-07-2024     15:47          88064 pcalua.exe
-a----        15-07-2024     15:47         899552 pcasvc.dll
-a----        15-07-2024     15:47         129536 pcaui.dll
-a----        15-07-2024     15:47         206848 pcaui.exe
-a----        07-12-2019     14:38          15360 pcbp.rs
-a----        07-12-2019     14:39            150 pcl.sep
-a----        15-07-2024     15:46        1150880 PCPKsp.dll
-a----        15-07-2024     15:47          60416 PCShellCommonProxyStub.dll
-a----        07-12-2019     14:38         390656 pcsvDevice.dll
-a----        17-11-2023     23:49          16384 pcwrun.exe
-a----        07-12-2019     14:38          22600 pcwum.dll
-a----        15-07-2024     15:48         178176 pcwutl.dll
-a----        15-07-2024     15:47         323584 pdh.dll
-a----        07-12-2019     14:39          62976 pdhui.dll
-a----        07-12-2019     14:38          20992 pegi-pt.rs
-a----        07-12-2019     14:38          20480 pegi.rs
-a----        17-11-2023     23:48         121344 PeopleAPIs.dll
-a----        15-07-2024     15:47         227328 PeopleBand.dll
-a----        15-07-2024     15:49         200704 PerceptionDevice.dll
-a----        07-12-2019     14:39          15872 PerceptionSimulation.ProxyStubs.dll
-a----        15-07-2024     15:48         553984 PerceptionSimulationExtensions.dll
-a----        16-10-2019     03:15        1366268 PerceptionSimulationLeftHandModel.glb
-a----        15-07-2024     15:48         806400 PerceptionSimulationManager.dll
-a----        16-10-2019     03:15        1368296 PerceptionSimulationRightHandModel.glb
-a----        09-08-2024     06:24         140396 perfc009.dat
-a----        17-11-2023     23:48          47616 perfctrs.dll
-a----        07-12-2019     14:42          33424 perfd009.dat
-a----        17-11-2023     23:48          43008 perfdisk.dll
-a----        09-08-2024     06:24         713646 perfh009.dat
-a----        07-12-2019     14:42         297062 perfi009.dat
-a----        07-12-2019     14:39         181760 perfmon.exe
-a----        07-12-2019     14:39         145519 perfmon.msc
-a----        17-11-2023     23:48          27136 perfnet.dll
-a----        17-11-2023     23:48          42496 perfos.dll
-a----        17-11-2023     23:48          46080 perfproc.dll
-a----        09-08-2024     06:24         847168 PerfStringBackup.INI
-a----        07-12-2019     14:39          83456 perftrack.dll
-a----        15-07-2024     15:48          83456 perfts.dll
-a----        15-07-2024     15:47         148992 PersonalizationCSP.dll
-a----        17-11-2023     23:48         111696 phoneactivate.exe
-a----        15-07-2024     15:47         249344 PhoneCallHistoryApis.dll
-a----        15-07-2024     15:47         459264 PhoneOm.dll
-a----        15-07-2024     15:46         111104 PhonePlatformAbstraction.dll
-a----        15-07-2024     15:46         889856 PhoneProviders.dll
-a----        15-07-2024     15:46         954880 PhoneService.dll
-a----        17-11-2023     23:47           2560 PhoneServiceRes.dll
-a----        07-12-2019     14:38           2259 PhoneSystemToastIcon.contrast-white.png
-a----        07-12-2019     14:38           1969 PhoneSystemToastIcon.png
-a----        15-07-2024     15:47         365056 Phoneutil.dll
-a----        07-12-2019     14:38           2560 PhoneutilRes.dll
-a----        15-07-2024     15:47         502272 PhotoMetadataHandler.dll
-a----        15-07-2024     15:49         619520 PhotoScreensaver.scr
-a----        07-12-2019     15:22         350208 photowiz.dll
-a----        15-07-2024     15:46         128208 PickerHost.exe
-a----        15-07-2024     15:47         389120 PickerPlatform.dll
-a----        07-12-2019     14:39          46592 pid.dll
-a----        17-11-2023     23:48        1088896 pidgenx.dll
-a----        07-12-2019     14:39          35840 pifmgr.dll
-a----        15-07-2024     15:47         196096 PimIndexMaintenance.dll
-a----        17-11-2023     23:48          63488 PimIndexMaintenanceClient.dll
-a----        15-07-2024     15:47         986112 Pimstore.dll
-a----        15-07-2024     15:46         112128 PinEnrollmentBroker.exe
-a----        15-07-2024     15:46         198144 PinEnrollmentHelper.dll
-a----        07-12-2019     14:39          22528 PING.EXE
-a----        15-07-2024     15:46         884384 pkeyhelper.dll
-a----        15-07-2024     15:48         250880 PkgMgr.exe
-a----        15-07-2024     15:48         682464 PktMon.exe
-a----        15-07-2024     15:48          41472 PktMonApi.dll
-a----        15-07-2024     15:47         300032 pku2u.dll
-a----        07-12-2019     14:39        1493504 pla.dll
-a----        07-12-2019     14:39          10752 plasrv.exe
-a----        15-07-2024     15:47          79872 playlistfolder.dll
-a----        17-11-2023     23:47          90112 PlaySndSrv.dll
-a----        17-11-2023     23:49         392704 PlayToDevice.dll
-a----        15-07-2024     15:48         614912 PlayToManager.dll
-a----        15-07-2024     15:48         164352 playtomenu.dll
-a----        15-07-2024     15:49         301568 PlayToReceiver.dll
-a----        17-11-2023     23:49          37888 PlayToStatusProvider.dll
-a----        17-11-2023     23:49          63968 ploptin.dll
-a----        17-11-2023     23:49          67584 pngfilt.dll
-a----        15-07-2024     15:47        2176512 pnidui.dll
-a----        17-11-2023     23:49         141312 pnpclean.dll
-a----        15-07-2024     15:47          91648 pnppolicy.dll
-a----        07-12-2019     14:39          15872 pnpts.dll
-a----        07-12-2019     14:39          49664 pnpui.dll
-a----        17-11-2023     23:49          62976 PnPUnattend.exe
-a----        15-07-2024     15:47         329728 pnputil.exe
-a----        15-07-2024     15:48         112640 PNPXAssoc.dll
-a----        07-12-2019     14:39          57856 PNPXAssocPrx.dll
-a----        07-12-2019     14:39          28160 pnrpauto.dll
-a----        17-11-2023     23:49          85504 Pnrphc.dll
-a----        17-11-2023     23:49          89088 pnrpnsp.dll
-a----        17-11-2023     23:49         352768 pnrpsvc.dll
-a----        15-07-2024     15:47         648400 policymanager.dll
-a----        15-07-2024     15:47         290304 policymanagerprecheck.dll
-a----        17-11-2023     23:48         354304 polstore.dll
-a----        25-05-2024     09:34         497664 poqexec.exe
-a----        15-07-2024     15:49         642048 PortableDeviceApi.dll
-a----        17-11-2023     23:50         128000 PortableDeviceClassExtension.dll
-a----        17-11-2023     23:50          69632 PortableDeviceConnectApi.dll
-a----        17-11-2023     23:50          74752 PortableDeviceStatus.dll
-a----        17-11-2023     23:49         162816 PortableDeviceSyncProvider.dll
-a----        17-11-2023     23:50         186880 PortableDeviceTypes.dll
-a----        17-11-2023     23:50         159232 PortableDeviceWiaCompat.dll
-a----        07-12-2019     14:39          34304 posetup.dll
-a----        15-07-2024     15:47          44032 pospaymentsworker.exe
-a----        17-11-2023     23:48          68096 POSyncServices.dll
-a----        07-12-2019     14:38          39936 pots.dll
-a----        15-07-2024     15:48         239616 powercfg.cpl
-a----        07-12-2019     14:39          96256 powercfg.exe
-a----        15-07-2024     15:48         212480 powercpl.dll
-a----        17-11-2023     23:48         296648 powrprof.dll
-a----        15-07-2024     15:47          70656 prauthproviders.dll
-a----        07-12-2019     14:40         282624 PresentationHost.exe
-a----        07-12-2019     14:40          83456 PresentationHostProxy.dll
-a----        15-07-2024     15:47          30208 prevhost.exe
-a----        07-12-2019     14:38          13824 prflbmsg.dll
-a----        17-11-2023     23:49          17408 print.exe
-a----        15-07-2024     15:47         373760 Print.PrintSupport.Source.dll
-a----        15-07-2024     15:47          93696 Print.Workflow.Source.dll
-a----        15-07-2024     15:46          86528 PrinterCleanupTask.dll
-a----        15-07-2024     15:46          92672 printfilterpipelineprxy.dll
-a----        15-07-2024     15:46         748544 printfilterpipelinesvc.exe
-a----        17-11-2023     23:47          77312 PrintIsolationHost.exe
-a----        15-07-2024     15:46          97792 PrintIsolationProxy.dll
-a----        15-07-2024     15:47          73216 PrintPlatformConfig.dll
-a----        15-07-2024     15:47         752128 PrintRenderAPIHost.DLL
-a----        15-07-2024     15:47          61952 printticketvalidation.dll
-a----        15-07-2024     15:47         757760 printui.dll
-a----        17-11-2023     23:49          64000 printui.exe
-a----        15-07-2024     15:47         463360 PrintWorkflowService.dll
-a----        15-07-2024     15:48         146432 PrintWSDAHost.dll
-a----        06-12-2019     22:06        5739008 prm0009.dll
-a----        17-11-2023     23:49         183808 prncache.dll
-a----        17-11-2023     23:49         239104 prnfldr.dll
-a----        15-07-2024     15:47         294912 prnntfy.dll
-a----        17-11-2023     23:49         190464 prntvpt.dll
-a----        17-11-2023     23:48          37888 ProductEnumerator.dll
-a----        15-07-2024     15:47         134496 profapi.dll
-a----        15-07-2024     15:47         178776 profext.dll
-a----        15-07-2024     15:47         140288 profprov.dll
-a----        15-07-2024     15:47         488448 profsvc.dll
-a----        15-07-2024     15:47         175616 profsvcext.dll
-a----        15-07-2024     15:47        1004232 propsys.dll
-a----        15-07-2024     15:47          68096 proquota.exe
-a----        15-07-2024     15:46         684544 provcore.dll
-a----        15-07-2024     15:46          99840 provdatastore.dll
-a----        17-11-2023     23:47          22016 provdiagnostics.dll
-a----        15-07-2024     15:46         382464 provengine.dll
-a----        15-07-2024     15:46         279040 provhandlers.dll
-a----        15-07-2024     15:49          78336 provisioningcommandscsp.dll
-a----        15-07-2024     15:46         256000 provisioningcsp.dll
-a----        15-07-2024     15:46         222208 ProvisioningHandlers.dll
-a----        15-07-2024     15:49          62976 provlaunch.exe
-a----        15-07-2024     15:49         111104 provmigrate.dll
-a----        15-07-2024     15:46         295424 provops.dll
-a----        15-07-2024     15:46         139776 provpackageapidll.dll
-a----        15-07-2024     15:49         203264 provplatformdesktop.dll
-a----        15-07-2024     15:46          79360 ProvPluginEng.dll
-a----        15-07-2024     15:49         487424 provsvc.dll
-a----        15-07-2024     15:49          80896 ProvSysprep.dll
-a----        07-12-2019     14:38         319488 provthrd.dll
-a----        15-07-2024     15:46          87040 provtool.exe
-a----        07-12-2019     14:38         171008 ProximityCommon.dll
-a----        17-11-2023     23:48          17408 ProximityCommonPal.dll
-a----        15-07-2024     15:46          26624 ProximityRtapiPal.dll
-a----        17-11-2023     23:48         320512 ProximityService.dll
-a----        15-07-2024     15:46          59392 ProximityServicePal.dll
-a----        15-07-2024     15:49         271184 ProximityUxHost.exe
-a----        07-12-2019     14:38          21144 prproc.exe
-a----        07-12-2019     14:38          86528 prvdmofcomp.dll
-a----        17-11-2023     23:48          20328 psapi.dll
-a----        07-12-2019     14:39             51 pscript.sep
-a----        07-12-2019     14:38          76600 PSHED.DLL
-a----        17-11-2023     23:49         599552 psisdecd.dll
-a----        07-12-2019     14:39          99840 psisrndr.ax
-a----        07-12-2019     14:38          54784 PSModuleDiscoveryProvider.dll
-a----        07-12-2019     14:38           4148 psmodulediscoveryprovider.mof
-a----        15-07-2024     15:47         763904 PsmServiceExtHost.dll
-a----        17-11-2023     23:48         247296 psmsrv.dll
-a----        17-11-2023     23:50         237568 psr.exe
-a----        07-12-2019     14:39          16384 pstask.dll
-a----        07-12-2019     14:38          16384 pstorec.dll
-a----        15-07-2024     15:46         217088 ptpprov.dll
-a----        17-11-2023     23:49         204800 puiapi.dll
-a----        17-11-2023     23:49         462848 puiobj.dll
-a----        15-07-2024     15:47         349696 PushToInstall.dll
-a----        17-11-2023     23:49         331264 pwlauncher.dll
-a----        07-12-2019     14:39          35840 pwlauncher.exe
-a----        07-12-2019     14:40          98304 pwrshplugin.dll
-a----        17-11-2023     23:49          32256 pwsso.dll
-a----        07-12-2019     14:39         157696 qasf.dll
-a----        07-12-2019     14:39         199680 qcap.dll
-a----        07-12-2019     14:39         252416 qdv.dll
-a----        17-11-2023     23:49         398848 qdvd.dll
-a----        15-07-2024     15:48         667648 qedit.dll
-a----        07-12-2019     14:39           2560 qedwipes.dll
-a----        15-07-2024     15:46        1481728 qmgr.dll
-a----        25-09-2023     20:43         483712 QualityUpdateAssistant.dll
-a----        17-11-2023     23:49        1687552 quartz.dll
-a----        15-07-2024     15:47         111104 Query.dll
-a----        15-07-2024     15:47         367104 QuickActionsDataModel.dll
-a----        15-07-2024     15:49         951808 quickassist.exe
-a----        15-07-2024     15:47         582144 QuietHours.dll
-a----        17-11-2023     23:49         287232 qwave.dll
-a----        07-12-2019     14:39          35840 RacEngn.dll
-a----        17-11-2023     23:50         133632 racpldlg.dll
-a----        07-12-2019     14:39         101888 radardt.dll
-a----        07-12-2019     14:39          72704 radarrs.dll
-a----        15-07-2024     15:47         416768 RADCUI.dll
-a----        17-11-2023     23:49          17408 rasadhlp.dll
-a----        15-07-2024     15:47        1016320 rasapi32.dll
-a----        17-11-2023     23:49         111616 rasauto.dll
-a----        17-11-2023     23:49          18432 rasautou.exe
-a----        15-07-2024     15:47         190464 raschap.dll
-a----        17-11-2023     23:49         101888 raschapext.dll
-a----        07-12-2019     14:39           1820 rasctrnm.h
-a----        07-12-2019     14:39          22016 rasctrs.dll
-a----        15-07-2024     15:47         509952 rascustom.dll
-a----        17-11-2023     23:49          87040 rasdiag.dll
-a----        17-11-2023     23:49          20992 rasdial.exe
-a----        17-11-2023     23:49         616960 rasdlg.dll
-a----        17-11-2023     23:50         135168 raserver.exe
-a----        15-07-2024     15:47         554496 rasgcw.dll
-a----        17-11-2023     23:49         188928 rasman.dll
-a----        15-07-2024     15:47        1015296 rasmans.dll
-a----        07-12-2019     14:39          61952 rasmbmgr.dll
-a----        15-07-2024     15:47         383488 RasMediaManager.dll
-a----        17-11-2023     23:49         310272 RASMM.dll
-a----        17-11-2023     23:49         360960 rasmontr.dll
-a----        07-12-2019     14:39          36864 rasphone.exe
-a----        17-11-2023     23:49         237056 rasplap.dll
-a----        15-07-2024     15:49         333824 rasppp.dll
-a----        17-11-2023     23:49         253952 rastapi.dll
-a----        15-07-2024     15:47         426496 rastls.dll
-a----        15-07-2024     15:47         261120 rastlsext.dll
-a----        15-07-2024     15:49         672256 rdbui.dll
-a----        17-11-2023     23:49         130544 rdp4vs.dll
-a----        15-07-2024     15:47        1570288 rdpbase.dll
-a----        07-12-2019     14:39          11264 rdpcfgex.dll
-a----        15-07-2024     15:48         453632 rdpclip.exe
-a----        15-07-2024     15:48        1285120 rdpcore.dll
-a----        15-07-2024     15:48        1631232 rdpcorets.dll
-a----        17-11-2023     23:49          43008 rdpcredentialprovider.dll
-a----        17-11-2023     23:49         433664 rdpencom.dll
-a----        17-11-2023     23:49         310088 rdpendp.dll
-a----        07-12-2019     14:39         184832 rdpinput.exe
-a----        13-07-2021     10:47        2371072 rdpnano.dll
-a----        17-11-2023     23:49         249856 RdpRelayTransport.dll
-a----        17-11-2023     23:49          57344 RdpSa.exe
-a----        17-11-2023     23:49          40960 RdpSaProxy.exe
-a----        07-12-2019     14:39          15360 RdpSaPs.dll
-a----        17-11-2023     23:49          34304 RdpSaUacHelper.exe
-a----        15-07-2024     15:47        1887728 rdpserverbase.dll
-a----        15-07-2024     15:47        1513472 rdpsharercom.dll
-a----        17-11-2023     23:49          98264 rdpudd.dll
-a----        17-11-2023     23:49         332800 rdpviewerax.dll
-a----        07-12-2019     14:38          48640 rdrleakdiag.exe
-a----        17-11-2023     23:49          96768 RDSAppXHelper.dll
-a----        15-07-2024     15:48         228864 rdsdwmdr.dll
-a----        15-07-2024     15:46          74752 rdsxvmaudio.dll
-a----        17-11-2023     23:49          89600 rdvvmtransport.dll
-a----        15-07-2024     15:49         734720 RDXService.dll
-a----        15-07-2024     15:49         425472 RDXTaskFactory.dll
-a----        15-07-2024     15:46          57856 readCloudDataSettings.exe
-a----        15-07-2024     15:47        1141224 ReAgent.dll
-a----        17-11-2023     23:48          44544 ReAgentc.exe
-a----        07-12-2019     14:38          13824 ReAgentTask.dll
-a----        17-11-2023     23:49         197632 recdisc.exe
-a----        07-12-2019     14:39          14336 recover.exe
-a----        15-07-2024     15:48         132608 recovery.dll
-a----        15-07-2024     15:48         946176 RecoveryDrive.exe
-a----        15-07-2024     15:47        1024000 refsutil.exe
-a----        07-12-2019     14:39          77312 reg.exe
-a----        17-11-2023     23:49         219136 regapi.dll
-a----        17-11-2023     23:48          52224 RegCtrl.dll
-a----        07-12-2019     14:39          11776 regedt32.exe
-a----        07-12-2019     14:39          15872 regidle.dll
-a----        07-12-2019     14:39          48128 regini.exe
-a----        07-12-2019     14:38          30208 Register-CimProvider.exe
-a----        22-03-2024     13:02         172032 regsvc.dll
-a----        07-12-2019     14:39          25088 regsvr32.exe
-a----        07-12-2019     14:38          36344 reguwpapi.dll
-a----        07-12-2019     14:38         181760 ReInfo.dll
-a----        17-11-2023     23:48         122880 rekeywiz.exe
-a----        17-11-2023     23:49          53760 relog.exe
-a----        15-07-2024     15:47         187904 RelPost.exe
-a----        15-07-2024     15:46          92104 remoteaudioendpoint.dll
-a----        17-11-2023     23:49          90624 remotepg.dll
-a----        07-12-2019     14:38          13312 RemotePosWorker.exe
-a----        07-12-2019     14:39         108032 remotesp.tsp
-a----        07-12-2019     14:38           1613 RemoteSystemToastIcon.contrast-white.png
-a----        07-12-2019     14:38           1124 RemoteSystemToastIcon.png
-a----        15-07-2024     15:48          63488 RemoteWipeCSP.dll
-a----        15-07-2024     15:46          68608 RemovableMediaProvisioningPlugin.dll
-a----        15-07-2024     15:48          74240 RemoveDeviceContextHandler.dll
-a----        07-12-2019     14:39          14848 RemoveDeviceElevated.dll
-a----        07-12-2019     14:39            256 removerootporterr.mof
-a----        17-11-2023     23:50           6656 rendezvousSession.tlb
-a----        07-12-2019     15:22         129024 repair-bde.exe
-a----        17-11-2023     23:49          22528 replace.exe
-a----        15-07-2024     15:48         142336 ReportingCSP.dll
-a----        07-12-2019     15:22         250696 RESAMPLEDMO.DLL
-a----        07-12-2019     14:39         113152 ResBParser.dll
-a----        15-07-2024     15:48        1257984 reseteng.dll
-a----        15-07-2024     15:48        2434016 ResetEngine.dll
-a----        17-11-2023     23:49          21480 ResetEngine.exe
-a----        15-07-2024     15:48         192512 ResetEngOnline.dll
-a----        07-12-2019     14:39         110592 resmon.exe
-a----        15-07-2024     15:48         528384 ResourceMapper.dll
-a----        15-07-2024     15:46          72992 ResourcePolicyClient.dll
-a----        15-07-2024     15:46         149984 ResourcePolicyServer.dll
-a----        07-12-2019     14:39           9571 ResPriHMImageList
-a----        07-12-2019     14:39           9196 ResPriHMImageListLowCost
-a----        07-12-2019     14:39           8977 ResPriImageList
-a----        07-12-2019     14:39           8690 ResPriImageListLowCost
-a----        07-12-2019     14:39            714 RestartManager.mof
-a----        07-12-2019     14:39            176 RestartManagerUninstall.mof
-a----        07-12-2019     14:38            759 RestartNowPower_80.contrast-black.png
-a----        07-12-2019     14:38            785 RestartNowPower_80.contrast-white.png
-a----        07-12-2019     14:38            759 RestartNowPower_80.png
-a----        07-12-2019     14:38           1091 RestartTonight_80.png
-a----        07-12-2019     14:38           1091 RestartTonight_80_contrast-black.png
-a----        07-12-2019     14:38           1003 RestartTonight_80_contrast-white.png
-a----        15-07-2024     15:48         615424 resutils.dll
-a----        07-12-2019     14:38         181760 rgb9rast.dll
-a----        15-07-2024     15:48         154112 Ribbons.scr
-a----        07-12-2019     14:39         612352 riched20.dll
-a----        07-12-2019     14:39          10240 riched32.dll
-a----        07-12-2019     14:39          58880 rilproxy.dll
-a----        15-07-2024     15:46         152576 RjvMDMConfig.dll
-a----        17-11-2023     23:47         579584 RMActivate.exe
-a----        17-11-2023     23:47         607744 RMActivate_isv.exe
-a----        17-11-2023     23:47         501760 RMActivate_ssp.exe
-a----        07-12-2019     14:38         501760 RMActivate_ssp_isv.exe
-a----        15-07-2024     15:47         152576 RMapi.dll
-a----        17-11-2023     23:48         164392 rmclient.dll
-a----        07-12-2019     14:39          18432 RmClient.exe
-a----        15-07-2024     15:46         104960 RMSRoamingSecurity.dll
-a----        15-07-2024     15:47         142848 rmttpmvscmgrsvr.exe
-a----        07-12-2019     14:39           2560 rnr20.dll
-a----        17-11-2023     23:48          49664 RoamingSecurity.dll
-a----        15-07-2024     15:48         172544 Robocopy.exe
-a----        07-12-2019     14:38         234432 rometadata.dll
-a----        07-12-2019     14:39           3468 rootporterr.mof
-a----        17-11-2023     23:49          50688 RotMgr.dll
-a----        07-12-2019     14:39          24576 ROUTE.EXE
-a----        17-11-2023     23:48          84480 RpcEpMap.dll
-a----        17-11-2023     23:48         208896 rpchttp.dll
-a----        07-12-2019     14:38          10240 RpcNs4.dll
-a----        07-12-2019     14:38          34304 rpcnsh.dll
-a----        07-12-2019     14:38          31744 RpcPing.exe
-a----        15-07-2024     15:47        1189680 rpcrt4.dll
-a----        17-11-2023     23:48          66296 RpcRtRemote.dll
-a----        15-07-2024     15:47        1324032 rpcss.dll
-a----        17-11-2023     23:50          48128 rrinstaller.exe
-a----        17-11-2023     23:48         208272 rsaenh.dll
-a----        15-07-2024     15:48         133632 rshx32.dll
-a----        12-10-2021     06:12          27328 RstMwEventLogMsg.dll
-a----        15-07-2024     15:47         207360 RstrtMgr.dll
-a----        15-07-2024     15:49         274432 rstrui.exe
-a----        15-07-2024     15:47          48640 rtffilt.dll
-a----        20-01-2024     11:02         185344 rtm.dll
-a----        21-04-2020     02:25        1091936 rtmcodecs.dll
-a----        15-07-2024     15:46         512512 RTMediaFrame.dll
-a----        21-04-2020     02:25          56672 rtmmvrortc.dll
-a----        21-04-2020     02:25        1354080 rtmpal.dll
-a----        21-04-2020     02:25        4898144 rtmpltfm.dll
-a----        23-02-2024     23:41          70144 rtutils.dll
-a----        15-07-2024     15:46         191816 RTWorkQ.dll
-a----        15-07-2024     15:46         100352 RuleBasedDS.dll
-a----        17-11-2023     23:49          20480 runas.exe
-a----        15-07-2024     15:47          89600 rundll32.exe
-a----        15-07-2024     15:47          61440 runexehelper.exe
-a----        15-07-2024     15:46          74240 RunLegacyCPLElevated.exe
-a----        15-07-2024     15:47          61952 runonce.exe
-a----        15-07-2024     15:46         102832 RuntimeBroker.exe
-a----        17-11-2023     23:48          82944 samcli.dll
-a----        15-07-2024     15:47         139264 samlib.dll
-a----        15-07-2024     15:47         941056 samsrv.dll
-a----        07-12-2019     14:38          14848 sas.dll
-a----        07-12-2019     14:39         964096 sbe.dll
-a----        07-12-2019     14:39         198144 sbeio.dll
-a----        07-12-2019     14:39          66048 sberes.dll
-a----        17-11-2023     23:49          38296 sbresources.dll
-a----        17-11-2023     23:48          23040 sbservicetrigger.dll
-a----        07-12-2019     14:39          72192 sc.exe
-a----        15-07-2024     15:48         113664 ScanPlugin.dll
-a----        17-11-2023     23:49         297472 scansetting.dll
-a----        13-03-2021     08:58          20227 scanstate.log
-a----        15-07-2024     15:47          51200 SCardBi.dll
-a----        15-07-2024     15:47          84480 SCardDlg.dll
-a----        15-07-2024     15:47         265216 SCardSvr.dll
-a----        07-12-2019     14:40          10429 ScavengeSpace.xml
-a----        07-12-2019     14:40          67072 scavengeui.dll
-a----        18-11-2019     19:16         482432 ScDetour.Dll
-a----        15-07-2024     15:47         205312 ScDeviceEnum.dll
-a----        15-07-2024     15:47         346112 scecli.dll
-a----        15-07-2024     15:47         583680 scesrv.dll
-a----        15-07-2024     15:47         600576 schannel.dll
-a----        17-11-2023     23:48          23040 schedcli.dll
-a----        17-11-2023     23:49         813056 schedsvc.dll
-a----        07-12-2019     14:38            538 ScheduleTime_80.contrast-black.png
-a----        07-12-2019     14:38            551 ScheduleTime_80.contrast-white.png
-a----        07-12-2019     14:38            538 ScheduleTime_80.png
-a----        17-11-2023     23:49         235008 schtasks.exe
-a----        15-07-2024     15:47         262656 scksp.dll
-a----        17-11-2023     23:49          89600 scripto.dll
-a----        15-07-2024     15:46          39936 scrnsave.scr
-a----        29-10-2023     08:36         228864 scrobj.dll
-a----        15-07-2024     15:47         229376 scrrun.dll
-a----        29-09-2021     08:12         312352 SCSANDBOXAPI.DLL
-a----        18-11-2019     19:17         224376 ScSecAuth.Dll
-a----        17-11-2023     23:48          24576 sdbinst.exe
-a----        17-11-2023     23:50          51712 sdchange.exe
-a----        15-07-2024     15:48        1265152 sdclt.exe
-a----        15-07-2024     15:48         794112 sdcpl.dll
-a----        15-07-2024     15:47         430592 SDDS.dll
-a----        17-11-2023     23:49        1244672 sdengin2.dll
-a----        07-12-2019     14:39          37224 SDFHost.dll
-a----        07-12-2019     14:38          36352 sdhcinst.dll
-a----        15-07-2024     15:48         232960 sdiageng.dll
-a----        15-07-2024     15:48          40448 sdiagnhost.exe
-a----        07-12-2019     14:39         192512 sdiagprv.dll
-a----        15-07-2024     15:48          68096 sdiagschd.dll
-a----        17-11-2023     23:49         543232 sdohlp.dll
-a----        17-11-2023     23:49         155648 sdrsvc.dll
-a----        17-11-2023     23:49         129536 sdshext.dll
-a----        23-02-2021     21:44        1435520 SEAPO64.dll
-a----        10-11-2022     23:13         245240 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0215.zip
-a----        10-11-2022     23:13         991995 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0222.zip
-a----        10-11-2022     23:13         137160 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0225.zip
-a----        10-11-2022     23:13        2970037 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0236.zip
-a----        10-11-2022     23:13         687773 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0245.zip
-a----        10-11-2022     23:13         652538 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0256.zip
-a----        10-11-2022     23:13         582339 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0274.zip
-a----        10-11-2022     23:13         204671 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0282.zip
-a----        10-11-2022     23:13        1002370 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0285.zip
-a----        10-11-2022     23:13         209956 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0287.zip
-a----        10-11-2022     23:13          41375 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0293.zip
-a----        10-11-2022     23:13         492057 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0295.zip
-a----        10-11-2022     23:13         245518 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0671.zip
-a----        10-11-2022     23:13         243645 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0701.zip
-a----        10-11-2022     23:13         489946 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_0897.zip
-a----        10-11-2022     23:13         123393 SEAPODAT.HDAUDIO.FUNC_01&VEN_10EC&DEV_1220.zip
-a----        10-11-2022     23:13          41411 SEAPODAT.INTELAUDIO.CTLR_DEV_34C8&LINKTYPE_05&DEVTYPE_05&VEN_8086&DEV_AE35.zip
-a----        10-11-2022     23:13          41278 SEAPODAT.INTELAUDIO.CTLR_DEV_A0C8&LINKTYPE_05&DEVTYPE_05&VEN_8086&DEV_AE35.zip
-a----        10-11-2022     23:13          48076 SEAPODAT.INTELAUDIO.DIF_0001&UIF_0000&FUNC_01&VEN_10EC&DEV_0274.zip
-a----        10-11-2022     23:13          41435 SEAPODAT.INTELAUDIO.DSP_CTLR_DEV_A0C8&VEN_8086&DEV_0222.zip
-a----        10-11-2022     23:13         733247 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0215.zip
-a----        10-11-2022     23:13          48365 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0225.zip
-a----        10-11-2022     23:13        2568404 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0236.zip
-a----        10-11-2022     23:13        2134148 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0245.zip
-a----        10-11-2022     23:13         341050 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0256.zip
-a----        10-11-2022     23:13         454524 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0274.zip
-a----        10-11-2022     23:13        2716858 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0285.zip
-a----        10-11-2022     23:13         395156 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0287.zip
-a----        10-11-2022     23:13          41377 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0293.zip
-a----        10-11-2022     23:13         533606 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0295.zip
-a----        10-11-2022     23:13          48350 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0298.zip
-a----        10-11-2022     23:13         123473 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_0897.zip
-a----        10-11-2022     23:13         123422 SEAPODAT.INTELAUDIO.FUNC_01&VEN_10EC&DEV_1220.zip
-a----        30-10-2020     08:24          40314 SEAPODAT.zip
-a----        15-07-2024     15:47         402944 Search.ProtocolHandler.MAPI2.dll
-a----        15-07-2024     15:47         272896 SearchFilterHost.exe
-a----        15-07-2024     15:47         413184 SearchFolder.dll
-a----        15-07-2024     15:47         935424 SearchIndexer.exe
-a----        15-07-2024     15:47         419328 SearchProtocolHost.exe
-a----        15-07-2024     15:46          62976 SebBackgroundManagerPolicy.dll
-a----        23-02-2021     21:44         288960 SECCNH64.exe
-a----        15-07-2024     15:48        1322976 SecConfig.efi
-a----        07-12-2019     14:39          41984 SecEdit.exe
-a----        15-07-2024     15:47         645296 sechost.dll
-a----        07-12-2019     14:38          10752 secinit.exe
-a----        17-11-2023     23:49          32768 seclogon.dll
-a----        23-02-2021     21:44        1176256 SECOCL64.exe
-a----        23-02-2021     21:44        1865824 SECOMN64.dll
-a----        23-02-2021     21:44         596184 SECOMN64.exe
-a----        17-11-2023     23:47         402432 secproc.dll
-a----        17-11-2023     23:47         399872 secproc_isv.dll
-a----        17-11-2023     23:47         112128 secproc_ssp.dll
-a----        07-12-2019     14:38         111616 secproc_ssp_isv.dll
-a----        17-11-2023     23:49          28672 secur32.dll
-a----        15-07-2024     15:48          98816 SecureBootEncodeUEFI.exe
-a----        23-02-2024     23:41         923000 securekernel.exe
-a----        15-07-2024     15:46         133120 SecureTimeAggregator.dll
-a----        07-12-2019     14:39           5632 security.dll
-a----        07-12-2019     14:38           5783 SecurityAndMaintenance.png
-a----        07-12-2019     14:38           2613 SecurityAndMaintenance_Alert.png
-a----        07-12-2019     14:38           6873 SecurityAndMaintenance_Error.png
-a----        15-07-2024     15:49         205592 SecurityCenterBroker.dll
-a----        17-11-2023     23:49          43064 SecurityCenterBrokerPS.dll
-a----        15-07-2024     15:46         443760 SecurityHealthAgent.dll
-a----        15-07-2024     15:46          99184 SecurityHealthHost.exe
-a----        17-11-2023     23:48         120176 SecurityHealthProxyStub.dll
-a----        15-07-2024     15:46         987616 SecurityHealthService.exe
-a----        15-07-2024     15:47         961536 SecurityHealthSSO.dll
-a----        15-07-2024     15:47          86016 SecurityHealthSystray.exe
-a----        25-09-2023     20:43         588656 sedplugins.dll
-a----        23-02-2021     21:44        1714712 SEHDHF64.dll
-a----        23-02-2021     21:44        1479768 SEHDRA64.dll
-a----        07-12-2019     14:38          41472 SEMgrPS.dll
-a----        15-07-2024     15:47        1223680 SEMgrSvc.dll
-a----        15-07-2024     15:48         147968 sendmail.dll
-a----        07-12-2019     14:39          77824 Sens.dll
-a----        07-12-2019     14:39          14848 SensApi.dll
-a----        15-07-2024     15:47        1265152 SensorDataService.exe
-a----        07-12-2019     14:38          27648 SensorPerformanceEvents.dll
-a----        15-07-2024     15:47         417280 SensorsApi.dll
-a----        17-11-2023     23:48         142848 SensorsClassExtension.dll
-a----        07-12-2019     14:38           2560 SensorsCpl.dll
-a----        15-07-2024     15:47         467456 SensorService.dll
-a----        17-11-2023     23:48          73024 SensorsNativeApi.dll
-a----        15-07-2024     15:47         221120 SensorsNativeApi.V2.dll
-a----        15-07-2024     15:47         162760 SensorsUtilsV2.dll
-a----        15-07-2024     15:47         181760 sensrsvc.dll
-a----        07-12-2019     14:39          19968 serialui.dll
-a----        15-07-2024     15:47         716544 services.exe
-a----        07-12-2019     14:39          92746 services.msc
-a----        15-07-2024     15:47         214512 ServicingUAPI.dll
-a----        07-12-2019     14:39          25600 serwvdrv.dll
-a----        15-07-2024     15:48         543232 SessEnv.dll
-a----        17-11-2023     23:49          88368 sessionmsg.exe
-a----        07-12-2019     14:38          92160 setbcdlocale.dll
-a----        15-07-2024     15:47         107008 sethc.exe
-a----        17-11-2023     23:48          30208 SetNetworkLocation.dll
-a----        17-11-2023     23:48          38912 SetNetworkLocationFlyout.dll
-a----        17-11-2023     23:48          36864 SetProxyCredential.dll
-a----        07-12-2019     14:39          30720 setspn.exe
-a----        15-07-2024     15:46         166912 SettingMonitor.dll
-a----        07-12-2019     14:38           8192 settings.dat
-a----        15-07-2024     15:47         600576 SettingsEnvironment.Desktop.dll
-a----        15-07-2024     15:47         150016 SettingsExtensibilityHandlers.dll
-a----        15-07-2024     15:46         272896 SettingsHandlers_Accessibility.dll
-a----        15-07-2024     15:49         243712 SettingsHandlers_AnalogShell.dll
-a----        15-07-2024     15:47         103424 SettingsHandlers_AppControl.dll
-a----        15-07-2024     15:46         159232 SettingsHandlers_AppExecutionAlias.dll
-a----        15-07-2024     15:47         332800 SettingsHandlers_Authentication.dll
-a----        15-07-2024     15:46         155136 SettingsHandlers_BackgroundApps.dll
-a----        15-07-2024     15:47         250368 SettingsHandlers_BatteryUsage.dll
-a----        15-07-2024     15:47         155648 SettingsHandlers_BrowserDeclutter.dll
-a----        15-07-2024     15:46         303104 SettingsHandlers_CapabilityAccess.dll
-a----        15-07-2024     15:49         199680 SettingsHandlers_Clipboard.dll
-a----        15-07-2024     15:46         143872 SettingsHandlers_ClosedCaptioning.dll
-a----        15-07-2024     15:47         180224 SettingsHandlers_ContentDeliveryManager.dll
-a----        15-07-2024     15:47         349184 SettingsHandlers_Cortana.dll
-a----        15-07-2024     15:47         608256 SettingsHandlers_Devices.dll
-a----        15-07-2024     15:47         450560 SettingsHandlers_Display.dll
-a----        15-07-2024     15:46         497664 SettingsHandlers_Flights.dll
-a----        15-07-2024     15:47         371712 SettingsHandlers_Fonts.dll
-a----        15-07-2024     15:47         162816 SettingsHandlers_ForceSync.dll
-a----        15-07-2024     15:47         281088 SettingsHandlers_Gaming.dll
-a----        15-07-2024     15:47          96256 SettingsHandlers_Geolocation.dll
-a----        15-07-2024     15:47         250368 SettingsHandlers_Gpu.dll
-a----        15-07-2024     15:49         462336 SettingsHandlers_HoloLens_Environment.dll
-a----        15-07-2024     15:47        1237504 SettingsHandlers_IME.dll
-a----        15-07-2024     15:47         194560 SettingsHandlers_InkingTypingPrivacy.dll
-a----        15-07-2024     15:46         339968 SettingsHandlers_InputPersonalization.dll
-a----        15-07-2024     15:47         866304 SettingsHandlers_Language.dll
-a----        15-07-2024     15:47         338432 SettingsHandlers_ManagePhone.dll
-a----        15-07-2024     15:46         266240 SettingsHandlers_Maps.dll
-a----        15-07-2024     15:47         102400 SettingsHandlers_Mouse.dll
-a----        15-07-2024     15:47         502272 SettingsHandlers_Notifications.dll
-a----        15-07-2024     15:47        3571712 SettingsHandlers_nt.dll
-a----        15-07-2024     15:46         190976 SettingsHandlers_OneCore_BatterySaver.dll
-a----        15-07-2024     15:46         111104 SettingsHandlers_OneCore_PowerAndSleep.dll
-a----        15-07-2024     15:47         103424 SettingsHandlers_OneDriveBackup.dll
-a----        15-07-2024     15:47         438784 SettingsHandlers_OptionalFeatures.dll
-a----        15-07-2024     15:47         560640 SettingsHandlers_PCDisplay.dll
-a----        15-07-2024     15:47         138240 SettingsHandlers_Pen.dll
-a----        15-07-2024     15:47         116224 SettingsHandlers_QuickActions.dll
-a----        15-07-2024     15:47         346112 SettingsHandlers_Region.dll
-a----        15-07-2024     15:48         141824 SettingsHandlers_SharedExperiences_Rome.dll
-a----        15-07-2024     15:46         228720 SettingsHandlers_SIUF.dll
-a----        15-07-2024     15:47         401920 SettingsHandlers_SpeechPrivacy.dll
-a----        15-07-2024     15:46         153088 SettingsHandlers_Startup.dll
-a----        15-07-2024     15:46         805872 SettingsHandlers_StorageSense.dll
-a----        15-07-2024     15:48         196952 SettingsHandlers_Troubleshoot.dll
-a----        15-07-2024     15:47         409088 SettingsHandlers_User.dll
-a----        15-07-2024     15:46         402944 SettingsHandlers_UserAccount.dll
-a----        15-07-2024     15:46         115200 SettingsHandlers_UserExperience.dll
-a----        15-07-2024     15:46         448000 SettingsHandlers_WorkAccess.dll
-a----        15-07-2024     15:46         714240 SettingSync.dll
-a----        15-07-2024     15:47        1128960 SettingSyncCore.dll
-a----        15-07-2024     15:46         640512 SettingSyncDownloadHelper.dll
-a----        15-07-2024     15:47         970632 SettingSyncHost.exe
-a----        15-07-2024     15:47        4674872 setupapi.dll
-a----        15-07-2024     15:47         157568 setupcl.dll
-a----        17-11-2023     23:48          10240 setupcl.exe
-a----        15-07-2024     15:48         209408 setupcln.dll
-a----        07-12-2019     14:39          20792 setupetw.dll
-a----        17-11-2023     23:48         137216 setupugc.exe
-a----        07-12-2019     14:39          58368 setx.exe
-a----        17-11-2023     23:49          12864 sfc.dll
-a----        07-12-2019     14:38          50176 sfc.exe
-a----        15-07-2024     15:47          64104 sfc_os.dll
-a----        15-07-2024     15:48         330584 SgrmBroker.exe
-a----        15-07-2024     15:48         417432 SgrmEnclave.dll
-a----        15-07-2024     15:48         412896 SgrmEnclave_secure.dll
-a----        15-07-2024     15:48          58224 SgrmLpac.exe
-a----        17-11-2023     23:48         145408 shacct.dll
-a----        15-07-2024     15:47          72704 shacctprofile.dll
-a----        15-07-2024     15:47         158720 SharedPCCSP.dll
-a----        15-07-2024     15:49         307200 SharedRealitySvc.dll
-a----        15-07-2024     15:46        1117696 ShareHost.dll
-a----        15-07-2024     15:49         237056 sharemediacpl.dll
-a----        15-07-2024     15:47         701968 SHCore.dll
-a----        15-07-2024     15:47         264192 shdocvw.dll
-a----        15-07-2024     15:47        7813800 shell32.dll
-a----        15-07-2024     15:47        1191216 ShellAppRuntime.exe
-a----        15-07-2024     15:46         914944 ShellCommonCommonProxyStub.dll
-a----        07-12-2019     14:39        1155584 shellstyle.dll
-a----        07-12-2019     14:39          10752 shfolder.dll
-a----        07-12-2019     14:38          29184 shgina.dll
-a----        07-12-2019     14:39          16740 ShiftJIS.uce
-a----        17-11-2023     23:48           7680 shimeng.dll
-a----        15-07-2024     15:47          34304 shimgvw.dll
-a----        15-07-2024     15:47         343496 shlwapi.dll
-a----        07-12-2019     14:38          21504 shpafact.dll
-a----        07-12-2019     14:39          60928 shrpubw.exe
-a----        15-07-2024     15:47         140800 shsetup.dll
-a----        15-07-2024     15:48         283648 shsvcs.dll
-a----        07-12-2019     14:39          24064 shunimpl.dll
-a----        07-12-2019     14:38          28160 shutdown.exe
-a----        07-12-2019     14:38          32256 shutdownext.dll
-a----        15-07-2024     15:47         322048 shutdownux.dll
-a----        15-07-2024     15:47         463872 shwebsvc.dll
-a----        17-11-2023     23:49          55296 signdrv.dll
-a----        07-12-2019     14:39          79360 sigverif.exe
-a----        15-07-2024     15:49         409792 SIHClient.exe
-a----        15-07-2024     15:47         111104 sihost.exe
-a----        07-12-2019     14:38         160256 SimAuth.dll
-a----        07-12-2019     14:38         105472 SimCfg.dll
-a----        07-12-2019     14:39           8192 simpdata.tlb
-a----        15-07-2024     15:48         309720 skci.dll
-a----        17-11-2023     23:48         146944 slc.dll
-a----        17-11-2023     23:48          22528 slcext.dll
-a----        07-12-2019     14:38          20352 SlideToShutDown.exe
-a----        07-12-2019     14:38         142904 slmgr.vbs
-a----        15-07-2024     15:47         581120 slui.exe
-a----        07-12-2019     14:38          83456 slwga.dll
-a----        07-12-2019     14:38          69788 SmallRoom.bin
-a----        15-07-2024     15:47          69632 SmartCardBackgroundPolicy.dll
-a----        15-07-2024     15:47         820736 SmartcardCredentialProvider.dll
-a----        15-07-2024     15:47         690688 SmartCardSimulator.dll
-a----        15-07-2024     15:46        2385408 smartscreen.exe
-a----        15-07-2024     15:46         313344 smartscreenps.dll
-a----        29-10-2023     08:36         116736 SMBHelperClass.dll
-a----        15-07-2024     15:47         309760 smbwmiv2.dll
-a----        17-11-2023     23:49         878048 SmiEngine.dll
-a----        17-11-2023     23:49          37232 smphost.dll
-a----        15-07-2024     15:48         643072 SmsRouterSvc.dll
-a----        17-11-2023     23:48         157152 smss.exe
-a----        15-07-2024     15:47         276920 SndVol.exe
-a----        15-07-2024     15:47         308224 SndVolSSO.dll
-a----        15-07-2024     15:48        3371520 SnippingTool.exe
-a----        07-12-2019     14:39          33792 snmpapi.dll
-a----        07-12-2019     14:38          16896 snmptrap.exe
-a----        07-12-2019     14:38            925 Snooze_80.contrast-black.png
-a----        07-12-2019     14:38            901 Snooze_80.contrast-white.png
-a----        07-12-2019     14:38            925 Snooze_80.png
-a----        17-11-2023     23:48         145920 socialapis.dll
-a----        07-12-2019     14:39         172544 softkbd.dll
-a----        07-12-2019     14:38          10752 softpub.dll
-a----        07-12-2019     14:39          28672 sort.exe
-a----        07-12-2019     14:38          46592 SortServer2003Compat.dll
-a----        07-12-2019     14:38          50176 SortWindows61.dll
-a----        17-11-2023     23:48          74544 SortWindows62.dll
-a----        17-11-2023     23:48          74456 SortWindows64.dll
-a----        07-12-2019     14:38          70144 SortWindows6Compat.dll
-a----        15-07-2024     15:49         165888 SpaceAgent.exe
-a----        17-11-2023     23:49         180736 spacebridge.dll
-a----        15-07-2024     15:49         772608 SpaceControl.dll
-a----        15-07-2024     15:48          80880 spaceman.exe
-a----        15-07-2024     15:46         152576 SpatialAudioLicenseSrv.exe
-a----        15-07-2024     15:46         225280 SpatializerApo.dll
-a----        15-07-2024     15:49         161280 SpatialStore.dll
-a----        17-11-2023     23:48         111104 spbcd.dll
-a----        07-12-2019     14:38           1520 SpeakersSystemToastIcon.contrast-white.png
-a----        07-12-2019     14:38            897 SpeakersSystemToastIcon.png
-a----        15-07-2024     15:49         879104 Spectrum.exe
-a----        15-07-2024     15:49          40960 SpectrumSyncClient.dll
-a----        15-07-2024     15:46        1580544 SpeechPal.dll
-a----        15-07-2024     15:47         113152 spfileq.dll
-a----        17-11-2023     23:49          95744 spinf.dll
-a----        07-12-2019     14:39          11264 spmpm.dll
-a----        07-12-2019     14:39          11776 spnet.dll
-a----        15-07-2024     15:46         123904 spoolss.dll
-a----        15-07-2024     15:46         837632 spoolsv.exe
-a----        15-07-2024     15:47         102400 spopk.dll
-a----        17-11-2023     23:49         287744 spp.dll
-a----        17-11-2023     23:48         130048 sppc.dll
-a----        15-07-2024     15:47         608768 sppcext.dll
-a----        15-07-2024     15:47         316416 sppcomapi.dll
-a----        07-12-2019     14:39         319488 sppcommdlg.dll
-a----        15-07-2024     15:47         572928 SppExtComObj.Exe
-a----        07-12-2019     14:39          44344 sppinst.dll
-a----        17-11-2023     23:49         275968 sppnp.dll
-a----        15-07-2024     15:47        1787208 sppobjs.dll
-a----        15-07-2024     15:47        4630408 sppsvc.exe
-a----        15-07-2024     15:47         363112 sppwinob.dll
-a----        07-12-2019     14:38         150528 sppwmi.dll
-a----        07-12-2019     14:39          15360 spwinsat.dll
-a----        17-11-2023     23:49         530928 spwizeng.dll
-a----        07-12-2019     14:39        5865488 spwizimg.dll
-a----        17-11-2023     23:49          17776 spwizres.dll
-a----        17-11-2023     23:50          11264 spwmp.dll
-a----        15-07-2024     15:48         762880 sqlsrv32.dll
-a----        07-12-2019     14:39          94208 sqlsrv32.rll
-a----        15-07-2024     15:47          49616 sqmapi.dll
-a----        15-07-2024     15:47         218112 srchadmin.dll
-a----        15-07-2024     15:49          74752 srclient.dll
-a----        15-07-2024     15:49         529408 srcore.dll
-a----        07-12-2019     14:39          19456 srdelayed.exe
-a----        07-12-2019     14:39           5120 SrEvents.dll
-a----        15-07-2024     15:47        3852288 SRH.dll
-a----        17-11-2023     23:49          96768 srhelper.dll
-a----        07-12-2019     14:39          11292 srms-apr-v.dat
-a----        07-12-2019     14:39          19485 srms-apr.dat
-a----        07-12-2019     14:39          59554 srms.dat
-a----        15-07-2024     15:47         157696 srpapi.dll
-a----        17-11-2023     23:49         252416 srrstr.dll
-a----        17-11-2023     23:49          59392 SrTasks.exe
-a----        17-11-2023     23:49          65024 srumapi.dll
-a----        17-11-2023     23:49         243200 srumsvc.dll
-a----        17-11-2023     23:48         118984 srvcli.dll
-a----        15-07-2024     15:47         305152 srvsvc.dll
-a----        07-12-2019     14:39          27648 srwmi.dll
-a----        17-11-2023     23:48          48128 sscore.dll
-a----        07-12-2019     14:38          13312 sscoreext.dll
-a----        15-07-2024     15:46         455168 ssdm.dll
-a----        17-11-2023     23:49          67584 ssdpapi.dll
-a----        15-07-2024     15:48         270336 ssdpsrv.dll
-a----        15-07-2024     15:47         189216 sspicli.dll
-a----        15-07-2024     15:47          29184 sspisrv.dll
-a----        07-12-2019     14:39         130064 SSShim.dll
-a----        15-07-2024     15:48         224768 ssText3d.scr
-a----        17-11-2023     23:49         211968 sstpsvc.dll
-a----        15-07-2024     15:46        5806160 StartTileData.dll
-a----        07-12-2019     14:38          25088 Startupscan.dll
-a----        17-11-2023     23:48         726792 StateRepository.Core.dll
-a----        17-11-2023     23:48          67072 stclient.dll
-a----        07-12-2019     14:38          18432 stdole2.tlb
-a----        07-12-2019     14:39           7168 stdole32.tlb
-a----        15-07-2024     15:48         332800 sti.dll
-a----        15-07-2024     15:48         234496 sti_ci.dll
-a----        15-07-2024     15:46         313344 stobject.dll
-a----        15-07-2024     15:48         103936 StorageContextHandler.dll
-a----        15-07-2024     15:48         161792 StorageUsage.dll
-a----        15-07-2024     15:48        2754048 storagewmi.dll
-a----        07-12-2019     14:39          26624 storagewmi_passthru.dll
-a----        07-12-2019     14:39         111616 stordiag.exe
-a----        15-07-2024     15:47         316416 storewuauth.dll
-a----        07-12-2019     14:39          73216 Storprop.dll
-a----        15-07-2024     15:48        1072128 StorSvc.dll
-a----        07-12-2019     14:38          27448 streamci.dll
-a----        15-07-2024     15:48         187904 StringFeedbackEngine.dll
-a----        15-07-2024     15:47         677288 StructuredQuery.dll
-a----        07-12-2019     14:39          93702 SubRange.uce
-a----        17-11-2023     23:49          17408 subst.exe
-a----        15-07-2024     15:48         190464 sud.dll
-a----        16-12-2021     08:02        1296045 SvBannerBackground.png
-a----        15-07-2024     15:47          57528 svchost.exe
-a----        07-12-2019     15:22         232960 svf.dll
-a----        07-12-2019     14:39          14336 svsvc.dll
-a----        15-07-2024     15:47         195072 SwitcherDataModel.dll
-a----        15-07-2024     15:47         500224 swprv.dll
-a----        17-11-2023     23:49          78336 sxproxy.dll
-a----        17-11-2023     23:48         662792 sxs.dll
-a----        07-12-2019     14:39          46080 sxshared.dll
-a----        17-11-2023     23:48          36864 sxssrv.dll
-a----        07-12-2019     14:39          30208 sxsstore.dll
-a----        17-11-2023     23:48          37376 sxstrace.exe
-a----        15-07-2024     15:48         521216 SyncCenter.dll
-a----        15-07-2024     15:49         616960 SyncController.dll
-a----        17-11-2023     23:49          47104 SyncHost.exe
-a----        07-12-2019     14:39          14336 SyncHostps.dll
-a----        15-07-2024     15:48         425984 SyncInfrastructure.dll
-a----        07-12-2019     14:39          37376 SyncInfrastructureps.dll
-a----        15-07-2024     15:49          64000 SyncProxy.dll
-a----        07-12-2019     14:39          81408 Syncreg.dll
-a----        06-12-2019     22:03           2560 SyncRes.dll
-a----        15-07-2024     15:46         380928 SyncSettings.dll
-a----        15-07-2024     15:49         388608 syncutil.dll
-a----        07-12-2019     14:39         125440 sysclass.dll
-a----        15-07-2024     15:47         148480 sysdm.cpl
-a----        15-07-2024     15:46         378880 SysFxUI.dll
-a----        15-07-2024     15:49        1005056 sysmain.dll
-a----        15-07-2024     15:48         423936 sysmon.ocx
-a----        07-12-2019     14:38          25600 sysntfy.dll
-a----        07-12-2019     14:39           3317 sysprint.sep
-a----        07-12-2019     14:39           3666 sysprtj.sep
-a----        17-11-2023     23:49          44008 SysResetErr.exe
-a----        07-12-2019     14:39          19456 syssetup.dll
-a----        15-07-2024     15:47         138752 systemcpl.dll
-a----        17-11-2023     23:48          30208 SystemEventsBrokerClient.dll
-a----        17-11-2023     23:48         251904 SystemEventsBrokerServer.dll
-a----        07-12-2019     14:39         110080 systeminfo.exe
-a----        07-12-2019     14:39          83968 SystemPropertiesAdvanced.exe
-a----        07-12-2019     14:39          83968 SystemPropertiesComputerName.exe
-a----        07-12-2019     14:39          83968 SystemPropertiesDataExecutionPrevention.exe
-a----        07-12-2019     14:39          83968 SystemPropertiesHardware.exe
-a----        07-12-2019     14:39          84480 SystemPropertiesPerformance.exe
-a----        07-12-2019     14:39          83968 SystemPropertiesProtection.exe
-a----        07-12-2019     14:39          83968 SystemPropertiesRemote.exe
-a----        15-07-2024     15:48         522264 systemreset.exe
-a----        15-07-2024     15:46         461184 SystemSettings.DataModel.dll
-a----        15-07-2024     15:49         183296 SystemSettings.DeviceEncryptionHandlers.dll
-a----        15-07-2024     15:47        1381376 SystemSettings.Handlers.dll
-a----        15-07-2024     15:47         166280 SystemSettings.SettingsExtensibility.dll
-a----        15-07-2024     15:47         519168 SystemSettings.UserAccountsHandlers.dll
-a----        15-07-2024     15:47         521280 SystemSettingsAdminFlows.exe
-a----        15-07-2024     15:46         206240 SystemSettingsBroker.exe
-a----        15-07-2024     15:48          43040 SystemSettingsRemoveDevice.exe
-a----        15-07-2024     15:47        4009984 SystemSettingsThresholdAdminFlowUI.dll
-a----        15-07-2024     15:46          56832 SystemSupportInfo.dll
-a----        15-07-2024     15:46          86016 SystemUWPLauncher.exe
-a----        07-12-2019     14:38          11776 systray.exe
-a----        15-07-2024     15:47         181760 t2embed.dll
-a----        07-12-2019     14:39         167936 Tabbtn.dll
-a----        17-11-2023     23:49          77824 TabbtnEx.dll
-a----        07-12-2019     14:39          86016 tabcal.exe
-a----        07-12-2019     14:39         712192 TabletPC.cpl
-a----        15-07-2024     15:47         233984 TabSvc.dll
-a----        07-12-2019     14:39          66560 takeown.exe
-a----        17-11-2023     23:49         997888 tapi3.dll
-a----        17-11-2023     23:49         247808 tapi32.dll
-a----        17-11-2023     23:49          34304 tapilua.dll
-a----        17-11-2023     23:49          66048 TapiMigPlugin.dll
-a----        07-12-2019     14:39          12288 tapiperf.dll
-a----        15-07-2024     15:48         317952 tapisrv.dll
-a----        07-12-2019     14:39          13312 TapiSysprep.dll
-a----        07-12-2019     14:39           2560 tapiui.dll
-a----        07-12-2019     14:39          15360 TapiUnattend.exe
-a----        17-11-2023     23:49          54784 tar.exe
-a----        15-07-2024     15:47         414720 TaskApis.dll
-a----        15-07-2024     15:46        1094656 taskbarcpl.dll
-a----        17-11-2023     23:49         420864 taskcomp.dll
-a----        15-07-2024     15:46        1543168 TaskFlowDataEngine.dll
-a----        15-07-2024     15:47          98296 taskhostw.exe
-a----        07-12-2019     14:39         101376 taskkill.exe
-a----        07-12-2019     14:39         106496 tasklist.exe
-a----        15-07-2024     15:47        1214400 Taskmgr.exe
-a----        17-11-2023     23:49         708720 taskschd.dll
-a----        07-12-2019     14:39         145059 taskschd.msc
-a----        17-11-2023     23:49          59392 TaskSchdPS.dll
-a----        15-07-2024     15:46          76288 tbauth.dll
-a----        15-07-2024     15:46          97208 tbs.dll
-a----        15-07-2024     15:48         820792 tcblaunch.exe
-a----        15-07-2024     15:48         225248 tcbloader.dll
-a----        07-12-2019     14:39          16896 tcmsetup.exe
-a----        07-12-2019     14:39           1673 tcpbidi.xml
-a----        17-11-2023     23:49         242688 tcpipcfg.dll
-a----        17-11-2023     23:49          38912 tcpmib.dll
-a----        15-07-2024     15:47         242688 tcpmon.dll
-a----        07-12-2019     14:39          60124 tcpmon.ini
-a----        17-11-2023     23:49          74752 tcpmonui.dll
-a----        07-12-2019     14:39          12800 TCPSVCS.EXE
-a----        17-11-2023     23:49          87552 tdc.ocx
-a----        17-11-2023     23:48        1128448 tdh.dll
-a----        15-07-2024     15:47         299520 TDLMigration.dll
-a----        30-11-2020     03:28         321416 TEEManagement64.dll
-a----        07-12-2019     14:39         109056 telephon.cpl
-a----        15-07-2024     15:46         145408 TelephonyInteractiveUser.dll
-a----        07-12-2019     14:38           2560 TelephonyInteractiveUserRes.dll
-a----        17-11-2023     23:48          74752 TempSignedLicenseExchangeTask.dll
-a----        17-11-2023     23:49         436224 termmgr.dll
-a----        15-07-2024     15:48        1264128 termsrv.dll
-a----        15-07-2024     15:46          77312 tetheringclient.dll
-a----        15-07-2024     15:46          53760 tetheringconfigsp.dll
-a----        07-12-2019     14:38          15360 TetheringIeProvider.dll
-a----        17-11-2023     23:47         227840 TetheringMgr.dll
-a----        15-07-2024     15:46         263168 tetheringservice.dll
-a----        15-07-2024     15:46         208896 TetheringStation.dll
-a----        15-07-2024     15:47        1015088 TextInputFramework.dll
-a----        15-07-2024     15:47        2261504 TextInputMethodFormatter.dll
-a----        15-07-2024     15:47         708112 TextShaping.dll
-a----        15-07-2024     15:48         420864 themecpl.dll
-a----        15-07-2024     15:46         142336 Themes.SsfDownload.ScheduledTask.dll
-a----        15-07-2024     15:47          70656 themeservice.dll
-a----        15-07-2024     15:47         487424 themeui.dll
-a----        08-04-2021     21:37           1370 ThirdPartyNoticesBySHS.txt
-a----        17-11-2023     23:48          67584 threadpoolwinrt.dll
-a----        15-07-2024     15:46         403432 thumbcache.dll
-a----        17-11-2023     23:48          34304 ThumbnailExtractionHost.exe
-a----        17-11-2023     23:48           2560 tier2punctuations.dll
-a----        07-12-2019     14:39          20480 TieringEngineProxy.dll
-a----        17-11-2023     23:49         326144 TieringEngineService.exe
-a----        15-07-2024     15:47         606720 TileDataRepository.dll
-a----        17-11-2023     23:48          35328 TimeBrokerClient.dll
-a----        17-11-2023     23:48         179712 TimeBrokerServer.dll
-a----        15-07-2024     15:46         243200 timedate.cpl
-a----        07-12-2019     14:38          11776 TimeDateMUICallback.dll
-a----        07-12-2019     14:39          32768 timeout.exe
-a----        15-07-2024     15:47          47616 timesync.dll
-a----        07-12-2019     14:38          15360 TimeSyncTask.dll
-a----        15-07-2024     15:48          47104 tlscsp.dll
-a----        17-11-2023     23:48          57856 tokenbinding.dll
-a----        15-07-2024     15:46        1531392 TokenBroker.dll
-a----        15-07-2024     15:46          48128 TokenBrokerCookies.exe
-a----        15-07-2024     15:47          78336 TokenBrokerUI.dll
-a----        07-12-2019     14:38         144862 tpm.msc
-a----        15-07-2024     15:46           3584 TpmCertResources.dll
-a----        07-12-2019     14:38          45056 tpmcompc.dll
-a----        15-07-2024     15:46        1173504 TpmCoreProvisioning.dll
-a----        07-12-2019     14:38          73728 TpmInit.exe
-a----        15-07-2024     15:46         467456 TpmTasks.dll
-a----        15-07-2024     15:46         273920 TpmTool.exe
-a----        15-07-2024     15:49         319488 tpmvsc.dll
-a----        15-07-2024     15:47         102400 tpmvscmgr.exe
-a----        15-07-2024     15:47         143872 tpmvscmgrsvr.exe
-a----        15-07-2024     15:47        3308032 tquery.dll
-a----        17-11-2023     23:49         429056 tracerpt.exe
-a----        07-12-2019     14:39          18432 TRACERT.EXE
-a----        07-12-2019     14:39          45056 traffic.dll
-a----        07-12-2019     14:38          10576 TransformPPSToWlan.xslt
-a----        07-12-2019     14:38           1688 TransformPPSToWlanCredentials.xslt
-a----        15-07-2024     15:46          62976 TransliterationRanker.dll
-a----        17-11-2023     23:49          20992 tree.com
-a----        15-07-2024     15:46         177664 trie.dll
-a----        17-11-2023     23:48         115200 trkwks.dll
-a----        15-07-2024     15:47         115712 TrustedSignalCredProv.dll
-a----        07-12-2019     14:39          16896 tsbyuv.dll
-a----        15-07-2024     15:47        1362432 tsf3gip.dll
-a----        15-07-2024     15:48          71168 tsgqec.dll
-a----        17-11-2023     23:49         415832 tsmf.dll
-a----        15-07-2024     15:47         153088 TSpkg.dll
-a----        15-07-2024     15:49          88576 TSSessionUX.dll
-a----        17-11-2023     23:49          69120 TSTheme.exe
-a----        17-11-2023     23:47          41472 TsUsbGDCoInstaller.dll
-a----        07-12-2019     14:38          13824 TsUsbRedirectionGroupPolicyExtension.dll
-a----        17-11-2023     23:49          78336 TSWbPrxy.exe
-a----        15-07-2024     15:47        1229824 TSWorkspace.dll
-a----        15-07-2024     15:47         283688 ttdinject.exe
-a----        07-12-2019     14:38          15512 ttdloader.dll
-a----        07-12-2019     14:38          67112 ttdplm.dll
-a----        15-07-2024     15:47         648752 ttdrecord.dll
-a----        07-12-2019     14:38        1597008 ttdrecordcpu.dll
-a----        15-07-2024     15:46         291840 TtlsAuth.dll
-a----        07-12-2019     14:38         224256 TtlsCfg.dll
-a----        17-11-2023     23:48         207360 TtlsExt.dll
-a----        15-07-2024     15:47          86896 tttracer.exe
-a----        17-11-2023     23:49          36864 tvratings.dll
-a----        15-07-2024     15:47         186880 twext.dll
-a----        15-07-2024     15:46        2110064 twinapi.appcore.dll
-a----        15-07-2024     15:47         669184 twinapi.dll
-a----        15-07-2024     15:46         659968 twinui.appcore.dll
-a----        15-07-2024     15:47        6331392 twinui.dll
-a----        15-07-2024     15:47        6939136 twinui.pcshell.dll
-a----        07-12-2019     14:38         119296 txflog.dll
-a----        07-12-2019     14:38          12800 txfw32.dll
-a----        17-11-2023     23:49          49664 typeperf.exe
-a----        15-07-2024     15:46         175616 tzautoupdate.dll
-a----        15-07-2024     15:47           2560 tzres.dll
-a----        07-12-2019     14:39          70144 tzsync.exe
-a----        07-12-2019     14:39           4096 tzsyncres.dll
-a----        07-12-2019     14:38          59904 tzutil.exe
-a----        17-11-2023     23:49         280576 ubpm.dll
-a----        17-11-2023     23:49          65024 ucmhc.dll
-a----        15-07-2024     15:46          62976 UCPDMgr.exe
-a----        17-11-2023     23:48        1046080 ucrtbase.dll
-a----        25-06-2022     03:01         826792 ucrtbase_clr0400.dll
-a----        17-11-2023     23:49         502160 ucrtbase_enclave.dll
-a----        07-12-2019     14:38          56632 ucsvc.exe
-a----        17-11-2023     23:49          70656 udhisapi.dll
-a----        15-07-2024     15:47        1009152 uDWM.dll
-a----        07-12-2019     14:38          39936 UefiCsp.dll
-a----        17-11-2023     23:48         111104 uexfat.dll
-a----        17-11-2023     23:48         152064 ufat.dll
-a----        15-07-2024     15:46         637952 UiaManager.dll
-a----        17-11-2023     23:48         269824 UIAnimation.dll
-a----        15-07-2024     15:46        3062784 UIAutomationCore.dll
-a----        17-11-2023     23:49          44544 uicom.dll
-a----        17-11-2023     23:49          13824 UIManagerBrokerps.dll
-a----        15-07-2024     15:47          38400 UIMgrBroker.exe
-a----        15-07-2024     15:47         290816 uireng.dll
-a----        07-12-2019     14:40        4080640 UIRibbon.dll
-a----        07-12-2019     14:40         835072 UIRibbonRes.dll
-a----        17-11-2023     23:48         186848 ulib.dll
-a----        17-11-2023     23:48          79360 umb.dll
-a----        07-12-2019     14:39          19968 umdmxfrm.dll
-a----        17-11-2023     23:47          65752 umpdc.dll
-a----        17-11-2023     23:49         133120 umpnpmgr.dll
-a----        15-07-2024     15:46          62464 umpo-overrides.dll
-a----        17-11-2023     23:47         178688 umpo.dll
-a----        15-07-2024     15:47         173056 umpoext.dll
-a----        07-12-2019     14:39          91648 umpowmi.dll
-a----        17-11-2023     23:49         396800 umrdp.dll
-a----        07-12-2019     14:39         207160 unattend.dll
-a----        15-07-2024     15:47         103936 unenrollhook.dll
-a----        15-07-2024     15:48         339456 UnifiedConsent.dll
-a----        07-12-2019     14:39         302080 unimdm.tsp
-a----        07-12-2019     14:39          79872 unimdmat.dll
-a----        07-12-2019     14:39          23040 uniplat.dll
-a----        15-07-2024     15:47        1192448 Unistore.dll
-a----        07-12-2019     14:38          42496 unlodctr.exe
-a----        07-12-2019     02:58         265216 unregmp2.exe
-a----        17-11-2023     23:48         595968 untfs.dll
-a----        15-07-2024     15:47        2632576 UpdateAgent.dll
-a----        15-07-2024     15:47         119296 updatecsp.dll
-a----        15-07-2024     15:47         328704 UpdateDeploymentProvider.dll
-a----        15-07-2024     15:46         232448 updatepolicy.dll
-a----        07-12-2019     14:38         121392 upfc.exe
-a----        15-07-2024     15:47          44544 UpgradeResultsUI.exe
-a----        15-07-2024     15:48         427520 upnp.dll
-a----        17-11-2023     23:49          43008 upnpcont.exe
-a----        17-11-2023     23:49         471552 upnphost.dll
-a----        15-07-2024     15:49          52224 UPPrinterInstaller.exe
-a----        15-07-2024     15:49         108032 UPPrinterInstallsCSP.dll
-a----        15-07-2024     15:47         717680 upshared.dll
-a----        15-07-2024     15:47         803328 uReFS.dll
-a----        07-12-2019     14:38         568320 uReFSv1.dll
-a----        17-11-2023     23:49          32768 ureg.dll
-a----        07-12-2019     14:39         236032 url.dll
-a----        15-07-2024     15:47        1949184 urlmon.dll
-a----        07-12-2019     14:38          41472 UsbCApi.dll
-a----        07-12-2019     14:38         119808 usbceip.dll
-a----        15-07-2024     15:46        1180672 usbmon.dll
-a----        07-12-2019     14:38          14336 usbperf.dll
-a----        07-12-2019     14:38          49152 UsbPmApi.dll
-a----        15-07-2024     15:48          78336 UsbSettingsHandlers.dll
-a----        17-11-2023     23:47          55808 UsbTask.dll
-a----        07-12-2019     14:38          93696 usbui.dll
-a----        15-07-2024     15:47        1700984 user32.dll
-a----        15-07-2024     15:47          49632 UserAccountBroker.exe
-a----        15-07-2024     15:47         128000 UserAccountControlSettings.dll
-a----        15-07-2024     15:47         102400 UserAccountControlSettings.exe
-a----        15-07-2024     15:46         201728 useractivitybroker.dll
-a----        15-07-2024     15:47         786944 usercpl.dll
-a----        07-12-2019     14:38           8192 UserDataAccessRes.dll
-a----        15-07-2024     15:47         455680 UserDataAccountApis.dll
-a----        07-12-2019     14:38          44544 UserDataLanguageUtil.dll
-a----        17-11-2023     23:48          64512 UserDataPlatformHelperUtil.dll
-a----        15-07-2024     15:47        1554944 UserDataService.dll
-a----        15-07-2024     15:47         122880 UserDataTimeUtil.dll
-a----        07-12-2019     14:38          46592 UserDataTypeHelperUtil.dll
-a----        15-07-2024     15:46         238592 UserDeviceRegistration.dll
-a----        15-07-2024     15:46         349184 UserDeviceRegistration.Ngc.dll
-a----        15-07-2024     15:47         178264 userenv.dll
-a----        15-07-2024     15:47          54272 userinit.exe
-a----        17-11-2023     23:48          25088 userinitext.dll
-a----        15-07-2024     15:47          61440 UserLanguageProfileCallback.dll
-a----        15-07-2024     15:47        1486848 usermgr.dll
-a----        15-07-2024     15:47          82160 usermgrcli.dll
-a----        15-07-2024     15:47         323584 UserMgrProxy.dll
-a----        07-12-2019     14:38          31232 usk.rs
-a----        15-07-2024     15:47         141824 usoapi.dll
-a----        15-07-2024     15:47         115712 UsoClient.exe
-a----        17-11-2023     23:48          39424 usocoreps.dll
-a----        15-07-2024     15:47        1414144 usocoreworker.exe
-a----        15-07-2024     15:47         570368 usosvc.dll
-a----        17-11-2023     23:48          79360 usp10.dll
-a----        07-12-2019     14:38          51712 ustprov.dll
-a----        15-07-2024     15:46         145920 UtcDecoderHost.exe
-a----        15-07-2024     15:47         105984 utcutil.dll
-a----        07-12-2019     14:38          48056 utildll.dll
-a----        15-07-2024     15:47         126464 Utilman.exe
-a----        17-11-2023     23:48         173056 uudf.dll
-a----        15-07-2024     15:47         139264 UvcModel.dll
-a----        15-07-2024     15:47         120320 UXInit.dll
-a----        17-11-2023     23:49         182144 uxlib.dll
-a----        07-12-2019     14:39          11576 uxlibres.dll
-a----        15-07-2024     15:47         627200 uxtheme.dll
-a----        15-07-2024     15:46         384920 vac.dll
-a----        15-07-2024     15:48         339968 VAN.dll
-a----        15-07-2024     15:48         366592 Vault.dll
-a----        15-07-2024     15:46         149504 VaultCDS.dll
-a----        15-07-2024     15:46         321536 vaultcli.dll
-a----        07-12-2019     14:38          30720 VaultCmd.exe
-a----        15-07-2024     15:46         119808 VaultRoaming.dll
-a----        15-07-2024     15:46         370688 vaultsvc.dll
-a----        17-11-2023     23:49         170496 VBICodec.ax
-a----        07-12-2019     14:39          47616 vbisurf.ax
-a----        15-07-2024     15:48         156160 vbsapi.dll
-a----        15-07-2024     15:47         618496 vbscript.dll
-a----        15-07-2024     15:49          85504 vbssysprep.dll
-a----        19-01-2024     20:38         412752 vcamp140.dll
-a----        17-11-2023     23:48         188416 VCardParser.dll
-a----        01-02-2002     19:02         348784 vccorlib140.dll
-a----        19-01-2024     20:38         196688 vcomp140.dll
-a----        01-02-2002     19:02         119376 vcruntime140.dll
-a----        01-02-2002     19:02          49744 vcruntime140_1.dll
-a----        25-06-2022     03:01          37800 vcruntime140_1_clr0400.dll
-a----        25-06-2022     03:01          98728 vcruntime140_clr0400.dll
-a----        01-02-2002     19:02          38512 vcruntime140_threads.dll
-a----        15-07-2024     15:47         724480 vds.exe
-a----        17-11-2023     23:49         256000 vdsbas.dll
-a----        17-11-2023     23:49         603648 vdsdyn.dll
-a----        17-11-2023     23:49          27136 vdsldr.exe
-a----        17-11-2023     23:49         135168 vdsutil.dll
-a----        17-11-2023     23:49          60928 vdsvd.dll
-a----        17-11-2023     23:49         109056 vds_ps.dll
-a----        07-12-2019     14:39          13824 verclsid.exe
-a----        07-12-2019     14:39         395584 verifier.dll
-a----        07-12-2019     14:38         177976 verifier.exe
-a----        07-12-2019     14:38         203264 verifiergui.exe
-a----        17-11-2023     23:48          32584 version.dll
-a----        17-11-2023     23:49         173272 vertdll.dll
-a----        15-07-2024     15:49          38912 vfpapi.dll
-a----        15-07-2024     15:49         320000 vfpctrl.exe
-a----        15-07-2024     15:46         147456 vfuprov.dll
-a----        07-12-2019     14:39          70656 vfwwdm32.dll
-a----        07-12-2019     14:38          37376 VhfUm.dll
-a----        17-11-2023     23:49          96744 vid.dll
-a----        07-12-2019     14:39          34304 vidcap.ax
-a----        15-07-2024     15:47         223232 VideoHandlers.dll
-a----        17-11-2023     23:50         115312 VIDRESZR.DLL
-a----        17-11-2023     23:48          70120 virtdisk.dll
-a----        15-07-2024     15:49          96256 VirtualMonitorManager.dll
-a----        07-12-2019     14:39          26128 VmApplicationHealthMonitorProxy.dll
-a----        15-07-2024     15:46          30536 vmbuspipe.dll
-a----        15-07-2024     15:46          27104 vmbuspiper.dll
-a----        15-07-2024     15:49         213488 vmbusvdev.dll
-a----        08-04-2021     19:23           6658 VmChipset Third-Party Notices.txt
-a----        15-07-2024     15:49        6558704 vmchipset.dll
-a----        15-07-2024     15:49         678896 vmcompute.dll
-a----        15-07-2024     15:49        3225584 vmcompute.exe
-a----        29-07-2024     11:23          31544 vmcomputeeventlog.dll
-a----        15-07-2024     15:49         262528 VmCrashDump.dll
-a----        15-07-2024     15:48         221184 vmdevicehost.dll
-a----        15-07-2024     15:49         293760 vmdynmem.dll
-a----        15-07-2024     15:49         250224 vmflexio.dll
-a----        15-07-2024     15:49         318448 vmiccore.dll
-a----        15-07-2024     15:49          63856 vmictimeprovider.dll
-a----        15-07-2024     15:49         547712 vmpmem.dll
-a----        15-07-2024     15:49         411120 vmprox.dll
-a----        15-07-2024     15:49         487424 vmrdvcore.dll
-a----        15-07-2024     15:49         531328 vmserial.dll
-a----        15-07-2024     15:49         287728 vmsif.dll
-a----        15-07-2024     15:49         123880 vmsifcore.dll
-a----        17-11-2023     23:49          29160 vmsifproxystub.dll
-a----        15-07-2024     15:49         382952 vmsmb.dll
-a----        15-07-2024     15:49         408544 VmSynthNic.dll
-a----        15-07-2024     15:49         404352 vmsynthstor.dll
-a----        15-07-2024     15:49         661472 vmuidevices.dll
-a----        15-07-2024     15:49         508784 vmusrv.dll
-a----        15-07-2024     15:49         131952 vmvirtio.dll
-a----        15-07-2024     15:49         408064 vmvpci.dll
-a----        15-07-2024     15:49        2403408 vmwp.exe
-a----        15-07-2024     15:49          80368 vmwpctrl.dll
-a----        17-11-2023     23:49         110560 vmwpevents.dll
-a----        15-07-2024     15:46         132608 VocabRoamingHandler.dll
-a----        15-07-2024     15:47          93184 VoiceActivationManager.dll
-a----        15-07-2024     15:46         151552 VoipRT.dll
-a----        15-07-2024     15:49         397192 vp9fs.dll
-a----        15-07-2024     15:47         736256 vpnike.dll
-a----        07-12-2019     14:39          54784 vpnikeapi.dll
-a----        07-12-2019     14:39          11264 VpnSohDesktop.dll
-a----        17-11-2023     23:48         265728 VPNv2CSP.dll
-a----        15-07-2024     15:49          69488 VrdUmed.dll
-a----        07-12-2019     14:40          20480 VscMgrPS.dll
-a----        07-12-2019     14:39         145920 vssadmin.exe
-a----        15-07-2024     15:47        1674240 vssapi.dll
-a----        17-11-2023     23:48          70656 vsstrace.dll
-a----        15-07-2024     15:47        1495040 VSSVC.exe
-a----        17-11-2023     23:48          61952 vss_ps.dll
-a----        02-08-2021     19:21        1115664 vulkan-1-999-0-0-0.dll
-a----        02-08-2021     19:21        1115664 vulkan-1.dll
-a----        02-08-2021     19:21        1870368 vulkaninfo-1-999-0-0-0.exe
-a----        02-08-2021     19:21        1870368 vulkaninfo.exe
-a----        15-07-2024     15:46         529920 w32time.dll
-a----        07-12-2019     14:38         108032 w32tm.exe
-a----        17-11-2023     23:48          36352 w32topl.dll
-a----        15-07-2024     15:47         154624 WaaSAssessment.dll
-a----        15-07-2024     15:47         112640 WaaSMedicAgent.exe
-a----        15-07-2024     15:47         369152 WaaSMedicCapsule.dll
-a----        15-07-2024     15:47          29184 WaaSMedicPS.dll
-a----        15-07-2024     15:47         427520 WaaSMedicSvc.dll
-a----        07-12-2019     14:39          70144 WABSyncProvider.dll
-a----        07-12-2019     14:39          42496 waitfor.exe
-a----        07-12-2019     14:38          12800 WalletBackgroundServiceProxy.dll
-a----        07-12-2019     14:38         104960 WalletProxy.dll
-a----        15-07-2024     15:49         442368 WalletService.dll
-a----        15-07-2024     15:47          23552 WallpaperHost.exe
-a----        17-11-2023     23:49         265216 wavemsp.dll
-a----        17-11-2023     23:50         329728 wbadmin.exe
-a----        15-07-2024     15:46         561664 wbemcomn.dll
-a----        15-07-2024     15:49        1623552 wbengine.exe
-a----        15-07-2024     15:47         886272 wbiosrvc.dll
-a----        17-11-2023     23:48          26112 wci.dll
-a----        15-07-2024     15:47         137728 wcimage.dll
-a----        15-07-2024     15:46         156160 wcmapi.dll
-a----        15-07-2024     15:46         246272 wcmcsp.dll
-a----        15-07-2024     15:46         986112 wcmsvc.dll
-a----        17-11-2023     23:47         140288 WcnApi.dll
-a----        17-11-2023     23:47         483840 wcncsvc.dll
-a----        07-12-2019     14:38          39936 WcnEapAuthProxy.dll
-a----        07-12-2019     14:38          37376 WcnEapPeerProxy.dll
-a----        17-11-2023     23:47          49664 WcnNetsh.dll
-a----        15-07-2024     15:46         346624 wcnwiz.dll
-a----        15-07-2024     15:47         297984 wc_storage.dll
-a----        07-12-2019     14:39         739840 wdc.dll
-a----        07-12-2019     14:38         105472 wdi.dll
-a----        15-07-2024     15:47         276992 wdigest.dll
-a----        15-07-2024     15:46         260608 wdmaud.drv
-a----        17-11-2023     23:49         260064 wdscore.dll
-a----        07-12-2019     14:38            614 WdsUnattendTemplate.xml
-a----        07-12-2019     14:38           4608 WEB.rs
-a----        15-07-2024     15:47         527872 webauthn.dll
-a----        15-07-2024     15:49         992768 WebcamUi.dll
-a----        15-07-2024     15:48         270336 webcheck.dll
-a----        15-07-2024     15:49         236544 WebClnt.dll
-a----        17-11-2023     23:48         595456 webio.dll
-a----        15-07-2024     15:48        1234944 webplatstorageserver.dll
-a----        15-07-2024     15:47        2573824 WebRuntimeManager.dll
-a----        15-07-2024     15:47        1395080 webservices.dll
-a----        17-11-2023     23:48          47104 Websocket.dll
-a----        23-02-2024     23:41          81408 wecapi.dll
-a----        15-07-2024     15:48         245248 wecsvc.dll
-a----        23-02-2024     23:41         107008 wecutil.exe
-a----        07-12-2019     14:39          28672 wephostsvc.dll
-a----        15-07-2024     15:47         891600 wer.dll
-a----        15-07-2024     15:48         893952 werconcpl.dll
-a----        15-07-2024     15:48         132608 wercplsupport.dll
-a----        23-02-2024     23:40          47104 werdiagcontroller.dll
-a----        23-02-2024     23:40          25384 WerEnc.dll
-a----        15-07-2024     15:47         255136 weretw.dll
-a----        15-07-2024     15:47         577920 WerFault.exe
-a----        15-07-2024     15:47         180336 WerFaultSecure.exe
-a----        15-07-2024     15:47         237424 wermgr.exe
-a----        15-07-2024     15:47         254464 wersvc.dll
-a----        15-07-2024     15:48         256000 werui.dll
-a----        15-07-2024     15:47         405088 wevtapi.dll
-a----        15-07-2024     15:48         137216 wevtfwd.dll
-a----        15-07-2024     15:47        1882624 wevtsvc.dll
-a----        17-11-2023     23:48         248320 wevtutil.exe
-a----        07-12-2019     14:39         146944 wextract.exe
-a----        07-12-2019     14:38         115109 WF.msc
-a----        15-07-2024     15:47          25088 wfapigp.dll
-a----        17-11-2023     23:47          41472 wfdprov.dll
-a----        07-12-2019     14:38          72704 WFDSConMgr.dll
-a----        15-07-2024     15:46         677888 WFDSConMgrSvc.dll
-a----        17-11-2023     23:49          90624 WfHC.dll
-a----        15-07-2024     15:49         966656 WFS.exe
-a----        17-11-2023     23:50         669696 WFSR.dll
-a----        07-12-2019     14:38          61752 whealogr.dll
-a----        07-12-2019     14:39          43008 where.exe
-a----        07-12-2019     14:39          17920 whhelper.dll
-a----        07-12-2019     14:39          73728 whoami.exe
-a----        17-11-2023     23:49          98816 wiaacmgr.exe
-a----        15-07-2024     15:48         813056 wiaaut.dll
-a----        15-07-2024     15:48         253952 wiadefui.dll
-a----        15-07-2024     15:48         173056 wiadss.dll
-a----        07-12-2019     14:39          11776 WiaExtensionHost64.dll
-a----        15-07-2024     15:48         118272 wiarpc.dll
-a----        17-11-2023     23:49         102912 wiascanprofiles.dll
-a----        15-07-2024     15:48         782336 wiaservc.dll
-a----        17-11-2023     23:49          90624 wiashext.dll
-a----        15-07-2024     15:48          18944 wiatrace.dll
-a----        07-12-2019     14:39          38912 wiawow64.exe
-a----        15-07-2024     15:46         284160 WiFiCloudStore.dll
-a----        17-11-2023     23:47          41984 WiFiConfigSP.dll
-a----        15-07-2024     15:46          45568 wifidatacapabilityhandler.dll
-a----        15-07-2024     15:46         387584 WiFiDisplay.dll
-a----        15-07-2024     15:46         804864 wifinetworkmanager.dll
-a----        17-11-2023     23:47         133608 wifitask.exe
-a----        07-12-2019     14:38           2404 WimBootCompress.ini
-a----        17-11-2023     23:48         765808 wimgapi.dll
-a----        17-11-2023     23:48         523120 wimserv.exe
-a----        15-07-2024     15:47         127488 win32appinventorycsp.dll
-a----        15-07-2024     15:47         148960 Win32AppSettingsProvider.dll
-a----        15-07-2024     15:47         248320 Win32CompatibilityAppraiserCSP.dll
-a----        15-07-2024     15:47         598016 win32k.sys
-a----        15-07-2024     15:47        2864128 win32kbase.sys
-a----        15-07-2024     15:47        3793408 win32kfull.sys
-a----        15-07-2024     15:47          30208 win32kns.sys
-a----        15-07-2024     15:46        1337344 win32spl.dll
-a----        15-07-2024     15:47         133920 win32u.dll
-a----        17-11-2023     23:47          28672 Win32_DeviceGuard.dll
-a----        15-07-2024     15:47         183296 winbio.dll
-a----        15-07-2024     15:49         521728 WinBioDataModel.dll
-a----        15-07-2024     15:49          79360 WinBioDataModelOOBE.exe
-a----        15-07-2024     15:48          43520 winbioext.dll
-a----        15-07-2024     15:47         205232 winbrand.dll
-a----        15-07-2024     15:47         437248 wincorlib.dll
-a----        17-11-2023     23:49          44544 wincredprovider.dll
-a----        15-07-2024     15:47         216576 wincredui.dll
-a----        15-07-2024     15:47        1681920 WindowManagement.dll
-a----        15-07-2024     15:47         658640 WindowManagementAPI.dll
-a----        15-07-2024     15:46        1075200 Windows.AccountsControl.dll
-a----        03-12-2020     22:33        5729280 Windows.AI.MachineLearning.dll
-a----        17-11-2023     23:48         108544 Windows.AI.MachineLearning.Preview.dll
-a----        15-07-2024     15:47         122880 Windows.ApplicationModel.Background.SystemEventsBroker.dll
-a----        17-11-2023     23:48          31232 Windows.ApplicationModel.Background.TimeBroker.dll
-a----        15-07-2024     15:46         781824 Windows.ApplicationModel.ConversationalAgent.dll
-a----        29-10-2023     08:35          73216 windows.applicationmodel.conversationalagent.internal.proxystub.dll
-a----        29-10-2023     08:35          89088 windows.applicationmodel.conversationalagent.proxystub.dll
-a----        15-07-2024     15:46         223744 Windows.ApplicationModel.Core.dll
-a----        15-07-2024     15:46         802288 windows.applicationmodel.datatransfer.dll
-a----        15-07-2024     15:46         954096 Windows.ApplicationModel.dll
-a----        15-07-2024     15:47         494080 Windows.ApplicationModel.LockScreen.dll
-a----        15-07-2024     15:47        2326528 Windows.ApplicationModel.Store.dll
-a----        15-07-2024     15:47          68096 Windows.ApplicationModel.Store.Preview.DOSettings.dll
-a----        15-07-2024     15:47         322048 Windows.ApplicationModel.Store.TestingFramework.dll
-a----        15-07-2024     15:47         577024 Windows.ApplicationModel.Wallet.dll
-a----        15-07-2024     15:46        2501120 Windows.CloudStore.dll
-a----        15-07-2024     15:47         894464 Windows.CloudStore.Schema.DesktopShell.dll
-a----        15-07-2024     15:46         861696 Windows.CloudStore.Schema.Shell.dll
-a----        15-07-2024     15:47         618496 Windows.Cortana.Desktop.dll
-a----        15-07-2024     15:47         366592 Windows.Cortana.OneCore.dll
-a----        15-07-2024     15:47         135168 Windows.Cortana.ProxyStub.dll
-a----        15-07-2024     15:47         536064 Windows.Data.Activities.dll
-a----        15-07-2024     15:46        6724608 Windows.Data.Pdf.dll
-a----        15-07-2024     15:46         647680 Windows.Devices.AllJoyn.dll
-a----        15-07-2024     15:46          90112 Windows.Devices.Background.dll
-a----        07-12-2019     14:38          20992 Windows.Devices.Background.ps.dll
-a----        15-07-2024     15:46        2314752 Windows.Devices.Bluetooth.dll
-a----        15-07-2024     15:46         100864 Windows.Devices.Custom.dll
-a----        07-12-2019     14:38          23552 Windows.Devices.Custom.ps.dll
-a----        15-07-2024     15:46         540440 Windows.Devices.Enumeration.dll
-a----        15-07-2024     15:46         190976 Windows.Devices.Haptics.dll
-a----        17-11-2023     23:48         288768 Windows.Devices.HumanInterfaceDevice.dll
-a----        15-07-2024     15:47         392192 Windows.Devices.Lights.dll
-a----        17-11-2023     23:48         596992 Windows.Devices.LowLevel.dll
-a----        15-07-2024     15:46         437760 Windows.Devices.Midi.dll
-a----        15-07-2024     15:47        2339328 Windows.Devices.Perception.dll
-a----        15-07-2024     15:49         484352 Windows.Devices.Picker.dll
-a----        15-07-2024     15:47        2078208 Windows.Devices.PointOfService.dll
-a----        15-07-2024     15:47          54784 Windows.Devices.Portable.dll
-a----        17-11-2023     23:48         154112 Windows.Devices.Printers.dll
-a----        17-11-2023     23:49          45056 Windows.Devices.Printers.Extensions.dll
-a----        15-07-2024     15:46         218624 Windows.Devices.Radios.dll
-a----        15-07-2024     15:48         219648 Windows.Devices.Scanners.dll
-a----        15-07-2024     15:47        1289216 Windows.Devices.Sensors.dll
-a----        17-11-2023     23:48         155136 Windows.Devices.SerialCommunication.dll
-a----        15-07-2024     15:46         807424 Windows.Devices.SmartCards.dll
-a----        15-07-2024     15:47         567808 Windows.Devices.SmartCards.Phone.dll
-a----        17-11-2023     23:48         424448 Windows.Devices.Usb.dll
-a----        15-07-2024     15:46         301568 Windows.Devices.WiFi.dll
-a----        17-11-2023     23:47         504832 Windows.Devices.WiFiDirect.dll
-a----        15-07-2024     15:46         199680 Windows.Energy.dll
-a----        15-07-2024     15:47         373760 Windows.FileExplorer.Common.dll
-a----        15-07-2024     15:46         916992 Windows.Gaming.Input.dll
-a----        15-07-2024     15:47         389120 Windows.Gaming.Preview.dll
-a----        15-07-2024     15:47          88064 Windows.Gaming.UI.GameBar.dll
-a----        17-11-2023     23:47         463360 Windows.Gaming.XboxLive.Storage.dll
-a----        15-07-2024     15:46        1712128 Windows.Globalization.dll
-a----        17-11-2023     23:48          62976 Windows.Globalization.Fontgroups.dll
-a----        15-07-2024     15:47         777728 Windows.Globalization.PhoneNumberFormatting.dll
-a----        15-07-2024     15:47         132776 Windows.Graphics.Display.BrightnessOverride.dll
-a----        15-07-2024     15:47         372576 Windows.Graphics.Display.DisplayEnhancementOverride.dll
-a----        15-07-2024     15:46         566664 Windows.Graphics.dll
-a----        15-07-2024     15:46        2308096 Windows.Graphics.Printing.3D.dll
-a----        15-07-2024     15:46         877568 Windows.Graphics.Printing.dll
-a----        15-07-2024     15:47        1252352 Windows.Graphics.Printing.Workflow.dll
-a----        15-07-2024     15:47          19968 Windows.Graphics.Printing.Workflow.Native.dll
-a----        07-12-2019     14:39         158208 Windows.Help.Runtime.dll
-a----        15-07-2024     15:47         782848 windows.immersiveshell.serviceprovider.dll
-a----        15-07-2024     15:47         133632 Windows.Internal.AdaptiveCards.XamlCardRenderer.dll
-a----        15-07-2024     15:46         546304 Windows.Internal.Bluetooth.dll
-a----        15-07-2024     15:47         231424 Windows.Internal.CapturePicker.Desktop.dll
-a----        15-07-2024     15:47         174592 Windows.Internal.CapturePicker.dll
-a----        15-07-2024     15:46         299520 Windows.Internal.Devices.Sensors.dll
-a----        15-07-2024     15:49         137216 Windows.Internal.Feedback.Analog.dll
-a----        07-12-2019     15:22          24064 Windows.Internal.Feedback.Analog.ProxyStub.dll
-a----        15-07-2024     15:47         253440 Windows.Internal.Graphics.Display.DisplayColorManagement.dll
-a----        15-07-2024     15:47         170496 Windows.Internal.Graphics.Display.DisplayEnhancementManagement.dll
-a----        15-07-2024     15:47        1132032 Windows.Internal.Management.dll
-a----        15-07-2024     15:46          67072 Windows.Internal.PlatformExtension.DevicePickerExperience.dll
-a----        15-07-2024     15:48          56832 Windows.Internal.PlatformExtension.MiracastBannerExperience.dll
-a----        15-07-2024     15:49         516608 Windows.Internal.PredictionUnit.dll
-a----        15-07-2024     15:48         158208 Windows.Internal.Security.Attestation.DeviceAttestation.dll
-a----        17-11-2023     23:49          48640 Windows.Internal.SecurityMitigationsBroker.dll
-a----        15-07-2024     15:47         904952 Windows.Internal.Shell.Broker.dll
-a----        15-07-2024     15:46          90112 windows.internal.shellcommon.AccountsControlExperience.dll
-a----        15-07-2024     15:46          61952 windows.internal.shellcommon.AppResolverModal.dll
-a----        15-07-2024     15:46         146328 Windows.Internal.ShellCommon.Broker.dll
-a----        15-07-2024     15:47          41984 windows.internal.shellcommon.FilePickerExperienceMEM.dll
-a----        15-07-2024     15:47          41472 Windows.Internal.ShellCommon.PrintExperience.dll
-a----        15-07-2024     15:46         317440 windows.internal.shellcommon.shareexperience.dll
-a----        15-07-2024     15:46          59392 windows.internal.shellcommon.TokenBrokerModal.dll
-a----        15-07-2024     15:46        1065472 Windows.Internal.Signals.dll
-a----        15-07-2024     15:46         258048 Windows.Internal.System.UserProfile.dll
-a----        15-07-2024     15:47         188928 Windows.Internal.Taskbar.dll
-a----        07-12-2019     14:38          93696 Windows.Internal.UI.BioEnrollment.ProxyStub.dll
-a----        07-12-2019     14:38         265216 Windows.Internal.UI.Logon.ProxyStub.dll
-a----        15-07-2024     15:47         433152 Windows.Internal.UI.Shell.WindowTabManager.dll
-a----        15-07-2024     15:46          71168 Windows.Management.EnrollmentStatusTracking.ConfigProvider.dll
-a----        15-07-2024     15:46         301056 Windows.Management.InprocObjects.dll
-a----        15-07-2024     15:46         111104 Windows.Management.ModernDeployment.ConfigProviders.dll
-a----        17-11-2023     23:47          34304 Windows.Management.Provisioning.ProxyStub.dll
-a----        15-07-2024     15:46         860672 Windows.Management.Service.dll
-a----        15-07-2024     15:46         254320 Windows.Management.Workplace.dll
-a----        17-11-2023     23:48          34304 Windows.Management.Workplace.WorkplaceSettings.dll
-a----        15-07-2024     15:49        1339904 Windows.Media.Audio.dll
-a----        15-07-2024     15:46         920576 Windows.Media.BackgroundMediaPlayback.dll
-a----        17-11-2023     23:48          13824 Windows.Media.BackgroundPlayback.exe
-a----        15-07-2024     15:46         593000 Windows.Media.Devices.dll
-a----        15-07-2024     15:49        7549296 Windows.Media.dll
-a----        17-11-2023     23:50        1393152 Windows.Media.Editing.dll
-a----        17-11-2023     23:48        1404416 Windows.Media.FaceAnalysis.dll
-a----        15-07-2024     15:46         791040 Windows.Media.Import.dll
-a----        15-07-2024     15:47         561480 Windows.Media.MediaControl.dll
-a----        15-07-2024     15:49        1071616 Windows.Media.MixedRealityCapture.dll
-a----        15-07-2024     15:46        1044992 Windows.Media.Ocr.dll
-a----        15-07-2024     15:46         918528 Windows.Media.Playback.BackgroundMediaPlayer.dll
-a----        15-07-2024     15:46         897024 Windows.Media.Playback.MediaPlayer.dll
-a----        17-11-2023     23:48         113664 Windows.Media.Playback.ProxyStub.dll
-a----        15-07-2024     15:46       10348448 Windows.Media.Protection.PlayReady.dll
-a----        15-07-2024     15:49         117248 Windows.Media.Renewal.dll
-a----        15-07-2024     15:47        1885696 Windows.Media.Speech.dll
-a----        17-11-2023     23:48         568832 Windows.Media.Speech.UXRes.dll
-a----        15-07-2024     15:49        1135104 Windows.Media.Streaming.dll
-a----        07-12-2019     15:22         218624 Windows.Media.Streaming.ps.dll
-a----        15-07-2024     15:49        4374248 Windows.Mirage.dll
-a----        17-11-2023     23:50          59392 Windows.Mirage.Internal.Capture.Pipeline.ProxyStub.dll
-a----        15-07-2024     15:49         867328 Windows.Mirage.Internal.dll
-a----        15-07-2024     15:46         107008 Windows.Networking.BackgroundTransfer.BackgroundManagerPolicy.dll
-a----        17-11-2023     23:48         505856 Windows.Networking.BackgroundTransfer.ContentPrefetchTask.dll
-a----        15-07-2024     15:46        1299968 Windows.Networking.BackgroundTransfer.dll
-a----        15-07-2024     15:46         737280 Windows.Networking.Connectivity.dll
-a----        15-07-2024     15:46         937472 Windows.Networking.dll
-a----        17-11-2023     23:48         215552 Windows.Networking.HostName.dll
-a----        15-07-2024     15:47         399872 Windows.Networking.NetworkOperators.ESim.dll
-a----        15-07-2024     15:46         143360 Windows.Networking.NetworkOperators.HotspotAuthentication.dll
-a----        17-11-2023     23:48         349184 Windows.Networking.Proximity.dll
-a----        17-11-2023     23:48         117760 Windows.Networking.ServiceDiscovery.Dnssd.dll
-a----        17-11-2023     23:48         148480 Windows.Networking.Sockets.PushEnabledApplication.dll
-a----        15-07-2024     15:47         631296 Windows.Networking.UX.EapRequestHandler.dll
-a----        15-07-2024     15:47        1523200 Windows.Networking.Vpn.dll
-a----        07-12-2019     14:39          75776 Windows.Networking.XboxLive.ProxyStub.dll
-a----        15-07-2024     15:47         588800 Windows.Payments.dll
-a----        15-07-2024     15:46        1058344 Windows.Perception.Stub.dll
-a----        15-07-2024     15:47         269824 Windows.Security.Authentication.Identity.Provider.dll
-a----        15-07-2024     15:46         975872 Windows.Security.Authentication.OnlineId.dll
-a----        15-07-2024     15:46        1146368 Windows.Security.Authentication.Web.Core.dll
-a----        15-07-2024     15:46         115880 Windows.Security.Credentials.UI.CredentialPicker.dll
-a----        15-07-2024     15:46         143872 Windows.Security.Credentials.UI.UserConsentVerifier.dll
-a----        15-07-2024     15:46          99808 Windows.Security.Integrity.dll
-a----        15-07-2024     15:47        1187712 Windows.Services.TargetedContent.dll
-a----        15-07-2024     15:47         223744 Windows.SharedPC.AccountManager.dll
-a----        15-07-2024     15:47         161792 Windows.SharedPC.CredentialProvider.dll
-a----        15-07-2024     15:47         326656 Windows.Shell.BlueLightReduction.dll
-a----        15-07-2024     15:47          99840 Windows.Shell.ServiceHostBuilder.dll
-a----        07-12-2019     14:38          22528 Windows.Shell.StartLayoutPopulationEvents.dll
-a----        15-07-2024     15:47        5861784 Windows.StateRepository.dll
-a----        17-11-2023     23:48         118768 Windows.StateRepositoryBroker.dll
-a----        15-07-2024     15:47         250736 Windows.StateRepositoryClient.dll
-a----        15-07-2024     15:47          59448 Windows.StateRepositoryCore.dll
-a----        17-11-2023     23:48        1338880 Windows.StateRepositoryPS.dll
-a----        15-07-2024     15:47         268800 Windows.StateRepositoryUpgrade.dll
-a----        15-07-2024     15:46         410776 Windows.Storage.ApplicationData.dll
-a----        29-10-2023     08:35         182784 Windows.Storage.Compression.dll
-a----        15-07-2024     15:47        8026064 windows.storage.dll
-a----        15-07-2024     15:47         203264 Windows.Storage.OneCore.dll
-a----        15-07-2024     15:46         798720 Windows.Storage.Search.dll
-a----        15-07-2024     15:46         356352 Windows.System.Diagnostics.dll
-a----        15-07-2024     15:46          55808 Windows.System.Diagnostics.Telemetry.PlatformTelemetryClient.dll
-a----        15-07-2024     15:46         107520 Windows.System.Diagnostics.TraceReporting.PlatformDiagnosticActions.dll
-a----        15-07-2024     15:46         756736 Windows.System.Launcher.dll
-a----        23-02-2024     23:42         150880 Windows.System.Profile.HardwareId.dll
-a----        15-07-2024     15:46          72192 Windows.System.Profile.PlatformDiagnosticsAndUsageDataSettings.dll
-a----        15-07-2024     15:47         141312 Windows.System.Profile.RetailInfo.dll
-a----        15-07-2024     15:46          62464 Windows.System.Profile.SystemId.dll
-a----        15-07-2024     15:46          54784 Windows.System.Profile.SystemManufacturers.dll
-a----        17-11-2023     23:48          23552 Windows.System.RemoteDesktop.dll
-a----        15-07-2024     15:46         322048 Windows.System.SystemManagement.dll
-a----        15-07-2024     15:46          94208 Windows.System.UserDeviceAssociation.dll
-a----        15-07-2024     15:46          65024 Windows.System.UserProfile.DiagnosticsSettings.dll
-a----        15-07-2024     15:46         105472 Windows.UI.Accessibility.dll
-a----        15-07-2024     15:46         287744 Windows.UI.AppDefaults.dll
-a----        15-07-2024     15:49         363520 Windows.UI.BioFeedback.dll
-a----        15-07-2024     15:47         409088 Windows.UI.BlockedShutdown.dll
-a----        15-07-2024     15:47        1040896 Windows.UI.Core.TextInput.dll
-a----        15-07-2024     15:47        1591808 Windows.UI.Cred.dll
-a----        15-07-2024     15:47         326144 Windows.UI.CredDialogController.dll
-a----        15-07-2024     15:47        1310360 Windows.UI.dll
-a----        15-07-2024     15:47         274432 Windows.UI.FileExplorer.dll
-a----        15-07-2024     15:47        1256448 Windows.UI.Immersive.dll
-a----        07-12-2019     14:38        4511744 Windows.UI.Input.Inking.Analysis.dll
-a----        15-07-2024     15:47        1824256 Windows.UI.Input.Inking.dll
-a----        15-07-2024     15:46         199168 Windows.UI.Internal.Input.ExpressiveInput.dll
-a----        07-12-2019     14:38          84480 Windows.UI.Internal.Input.ExpressiveInput.Resource.dll
-a----        15-07-2024     15:47        3093504 Windows.UI.Logon.dll
-a----        15-07-2024     15:47          86016 Windows.UI.NetworkUXController.dll
-a----        15-07-2024     15:49        2744320 Windows.UI.PicturePassword.dll
-a----        15-07-2024     15:47         911872 Windows.UI.Search.dll
-a----        15-07-2024     15:49          41472 Windows.UI.Shell.dll
-a----        17-11-2023     23:48        1432064 Windows.UI.Shell.Internal.AdaptiveCards.dll
-a----        15-07-2024     15:46         141312 Windows.UI.Storage.dll
-a----        15-07-2024     15:46        4025344 Windows.UI.Xaml.Controls.dll
-a----        15-07-2024     15:46       17531392 Windows.UI.Xaml.dll
-a----        15-07-2024     15:46         974336 Windows.UI.Xaml.InkControls.dll
-a----        15-07-2024     15:46        1360896 Windows.UI.Xaml.Maps.dll
-a----        15-07-2024     15:46        1268224 Windows.UI.Xaml.Phone.dll
-a----        07-12-2019     14:38         706048 Windows.UI.Xaml.Resources.19h1.dll
-a----        15-07-2024     15:46          44032 Windows.UI.Xaml.Resources.Common.dll
-a----        07-12-2019     14:38         456704 Windows.UI.Xaml.Resources.rs1.dll
-a----        07-12-2019     14:38         508928 Windows.UI.Xaml.Resources.rs2.dll
-a----        07-12-2019     14:38         617472 Windows.UI.Xaml.Resources.rs3.dll
-a----        07-12-2019     14:38         645632 Windows.UI.Xaml.Resources.rs4.dll
-a----        07-12-2019     14:38         700928 Windows.UI.Xaml.Resources.rs5.dll
-a----        07-12-2019     14:38         301056 Windows.UI.Xaml.Resources.th.dll
-a----        07-12-2019     14:38         241664 Windows.UI.Xaml.Resources.win81.dll
-a----        07-12-2019     14:38         142336 Windows.UI.Xaml.Resources.win8rtm.dll
-a----        15-07-2024     15:49         210944 Windows.UI.XamlHost.dll
-a----        15-07-2024     15:47          65536 Windows.WARP.JITService.dll
-a----        15-07-2024     15:47          73216 Windows.WARP.JITService.exe
-a----        15-07-2024     15:46         235520 Windows.Web.Diagnostics.dll
-a----        15-07-2024     15:46         775168 Windows.Web.dll
-a----        15-07-2024     15:46        1514496 Windows.Web.Http.dll
-a----        28-07-2024     12:12          72304 WindowsAccessBridge-64.dll
-a----        15-07-2024     15:48          62464 WindowsActionDialog.exe
-a----        15-07-2024     15:47        1792824 WindowsCodecs.dll
-a----        17-11-2023     23:48         274944 WindowsCodecsExt.dll
-a----        17-11-2023     23:50       32610352 WindowsCodecsRaw.dll
-a----        07-12-2019     14:40           1649 WindowsCodecsRaw.txt
-a----        15-07-2024     15:47         126976 WindowsDefaultHeatProcessor.dll
-a----        15-07-2024     15:47         732160 WindowsInternal.ComposableShell.ComposerFramework.dll
-a----        15-07-2024     15:47         169472 WindowsInternal.ComposableShell.DesktopHosting.dll
-a----        15-07-2024     15:47          77312 WindowsInternal.Shell.CompUiActivation.dll
-a----        15-07-2024     15:47         290304 windowslivelogin.dll
-a----        15-07-2024     15:46          84240 WindowsManagementServiceWinRt.ProxyStub.dll
-a----        15-07-2024     15:47        1211904 windowsperformancerecordercontrol.dll
-a----        07-12-2019     14:38            759 WindowsSecurityIcon.png
-a----        15-07-2024     15:47        2968064 windowsudk.shellcommon.dll
-a----        15-07-2024     15:47          70656 WindowsUpdateElevatedInstaller.exe
-a----        17-11-2023     23:49          93184 winethc.dll
-a----        15-07-2024     15:49          31744 WinFax.dll
-a----        15-07-2024     15:47        1088808 winhttp.dll
-a----        17-11-2023     23:49         102912 winhttpcom.dll
-a----        15-07-2024     15:48         130048 WinHvEmulation.dll
-a----        15-07-2024     15:48         135168 WinHvPlatform.dll
-a----        15-07-2024     15:47        5039616 wininet.dll
-a----        07-12-2019     14:39          70144 wininetlui.dll
-a----        15-07-2024     15:47         424648 wininit.exe
-a----        15-07-2024     15:47          83320 wininitext.dll
-a----        15-07-2024     15:47         513024 winipcfile.dll
-a----        15-07-2024     15:47         904704 winipcsecproc.dll
-a----        17-11-2023     23:48         101888 winipsec.dll
-a----        07-12-2019     14:38         150528 winjson.dll
-a----        15-07-2024     15:47         190464 Winlangdb.dll
-a----        15-07-2024     15:47        1848128 winload.efi
-a----        15-07-2024     15:47        1573808 winload.exe
-a----        15-07-2024     15:47         905728 winlogon.exe
-a----        15-07-2024     15:47          86016 winlogonext.dll
-a----        17-11-2023     23:50        1771752 winmde.dll
-a----        07-12-2019     14:38          41472 winml.dll
-a----        17-11-2023     23:47         148376 winmm.dll
-a----        07-12-2019     14:38         144592 winmmbase.dll
-a----        15-07-2024     15:47        2351104 winmsipc.dll
-a----        17-11-2023     23:48          88064 WinMsoIrmProtector.dll
-a----        15-07-2024     15:47          19968 winnlsres.dll
-a----        17-11-2023     23:48          36808 winnsi.dll
-a----        17-11-2023     23:48          81920 WinOpcIrmProtector.dll
-a----        15-07-2024     15:47         549760 WinREAgent.dll
-a----        15-07-2024     15:47        1410080 winresume.efi
-a----        15-07-2024     15:47        1208144 winresume.exe
-a----        07-12-2019     14:38             33 winrm.cmd
-a----        07-12-2019     14:38         204074 winrm.vbs
-a----        17-11-2023     23:48          49152 winrnr.dll
-a----        07-12-2019     14:38          52736 winrs.exe
-a----        17-11-2023     23:48         122368 winrscmd.dll
-a----        07-12-2019     14:38          29184 winrshost.exe
-a----        07-12-2019     14:38           2048 winrsmgr.dll
-a----        07-12-2019     14:38          14848 winrssrv.dll
-a----        17-11-2023     23:48          20480 WinRTNetMUAHostServer.exe
-a----        17-11-2023     23:48         184832 WinRtTracing.dll
-a----        17-11-2023     23:49        2811392 WinSAT.exe
-a----        17-11-2023     23:49         377856 WinSATAPI.dll
-a----        17-11-2023     23:48         252928 WinSCard.dll
-a----        17-11-2023     23:49         390632 WinSetupUI.dll
-a----        17-11-2023     23:48          19968 winshfhc.dll
-a----        15-07-2024     15:47         334848 winsku.dll
-a----        17-11-2023     23:48          98304 winsockhc.dll
-a----        15-07-2024     15:46         651264 winspool.drv
-a----        15-07-2024     15:47        1070824 winsqlite3.dll
-a----        07-12-2019     14:39          26624 WINSRPC.DLL
-a----        07-12-2019     14:38          62976 winsrv.dll
-a----        17-11-2023     23:48         103424 winsrvext.dll
-a----        17-11-2023     23:49         353440 winsta.dll
-a----        07-12-2019     14:38         822272 WinSync.dll
-a----        07-12-2019     14:39         230400 WinSyncMetastore.dll
-a----        07-12-2019     14:39         136704 WinSyncProviders.dll
-a----        15-07-2024     15:47         423032 wintrust.dll
-a----        15-07-2024     15:47        1408088 WinTypes.dll
-a----        07-12-2019     14:38          29696 winusb.dll
-a----        07-12-2019     14:39          59392 winver.exe
-a----        17-11-2023     23:47          45568 WiredNetworkCSP.dll
-a----        15-07-2024     15:47         260096 wisp.dll
-a----        17-11-2023     23:48          37376 witnesswmiv2provider.dll
-a----        17-11-2023     23:48          92112 wkscli.dll
-a----        15-07-2024     15:48         290400 wkspbroker.exe
-a----        15-07-2024     15:48         140288 wkspbrokerAx.dll
-a----        17-11-2023     23:49         450560 wksprt.exe
-a----        07-12-2019     14:38          31744 wksprtPS.dll
-a----        15-07-2024     15:47         308224 wkssvc.dll
-a----        15-07-2024     15:46         471184 wlanapi.dll
-a----        17-11-2023     23:47         310784 wlancfg.dll
-a----        17-11-2023     23:49         588800 WLanConn.dll
-a----        17-11-2023     23:47         202240 wlandlg.dll
-a----        07-12-2019     14:38         103424 wlanext.exe
-a----        17-11-2023     23:47         394752 wlangpui.dll
-a----        17-11-2023     23:47         216064 WLanHC.dll
-a----        17-11-2023     23:47          16896 wlanhlp.dll
-a----        15-07-2024     15:47         755712 WlanMediaManager.dll
-a----        17-11-2023     23:49         400384 WlanMM.dll
-a----        15-07-2024     15:46         436224 wlanmsm.dll
-a----        17-11-2023     23:47         776704 wlanpref.dll
-a----        17-11-2023     23:47          69120 WlanRadioManager.dll
-a----        15-07-2024     15:46         481280 wlansec.dll
-a----        15-07-2024     15:46        2654208 wlansvc.dll
-a----        17-11-2023     23:47          36352 wlansvcpal.dll
-a----        17-11-2023     23:48         422400 wlanui.dll
-a----        07-12-2019     14:38           3584 wlanutil.dll
-a----        15-07-2024     15:47         356864 Wldap32.dll
-a----        15-07-2024     15:47         184520 wldp.dll
-a----        17-11-2023     23:47         122368 wlgpclnt.dll
-a----        15-07-2024     15:47         713728 wlidcli.dll
-a----        15-07-2024     15:47         300544 wlidcredprov.dll
-a----        20-01-2024     11:02         102400 wlidfdp.dll
-a----        20-01-2024     11:02          67072 wlidnsp.dll
-a----        15-07-2024     15:46         667136 wlidprov.dll
-a----        07-12-2019     14:38          30208 wlidres.dll
-a----        15-07-2024     15:46        2256896 wlidsvc.dll
-a----        17-11-2023     23:49          69264 wlrmdr.exe
-a----        17-11-2023     23:50         761392 WMADMOD.DLL
-a----        17-11-2023     23:50         745432 WMADMOE.DLL
-a----        15-07-2024     15:46        1820704 WMALFXGFXDSP.dll
-a----        07-12-2019     15:22         341904 WMASF.DLL
-a----        07-12-2019     15:22          14336 wmcodecdspps.dll
-a----        17-11-2023     23:50          40960 wmdmlog.dll
-a----        07-12-2019     15:22          95744 wmdmps.dll
-a----        07-12-2019     14:39           7680 wmdrmsdk.dll
-a----        07-12-2019     03:01           2560 wmerror.dll
-a----        07-12-2019     14:38           5632 wmi.dll
-a----        17-11-2023     23:47          49152 wmiclnt.dll
-a----        17-11-2023     23:47         361952 wmicmiplugin.dll
-a----        17-11-2023     23:48         176640 wmidcom.dll
-a----        17-11-2023     23:50         202752 wmidx.dll
-a----        07-12-2019     14:38         144673 WmiMgmt.msc
-a----        07-12-2019     14:39          31232 wmiprop.dll
-a----        07-12-2019     14:38         215552 wmitomi.dll
-a----        17-11-2023     23:50        1357312 WMNetMgr.dll
-a----        15-07-2024     15:49       11455488 wmp.dll
-a----        17-11-2023     23:50        1568256 WMPDMC.exe
-a----        07-12-2019     15:22         373248 WmpDui.dll
-a----        17-11-2023     23:50         221696 wmpdxm.dll
-a----        17-11-2023     23:50         312640 wmpeffects.dll
-a----        17-11-2023     23:48         381952 WMPhoto.dll
-a----        17-11-2023     23:50           2560 wmploc.DLL
-a----        17-11-2023     23:50         389544 wmpps.dll
-a----        17-11-2023     23:50         129024 wmpshell.dll
-a----        15-07-2024     15:47          20480 wmsgapi.dll
-a----        07-12-2019     14:38         993792 WMSPDMOD.DLL
-a----        17-11-2023     23:50        1253376 WMSPDMOE.DLL
-a----        23-02-2024     23:42        2454544 WMVCORE.DLL
-a----        23-02-2024     23:42        2524808 WMVDECOD.DLL
-a----        17-11-2023     23:50         214016 wmvdspa.dll
-a----        07-12-2019     15:22        2298600 WMVENCOD.DLL
-a----        07-12-2019     15:22         347096 WMVSDECD.DLL
-a----        07-12-2019     15:22         451584 WMVSENCD.DLL
-a----        17-11-2023     23:50         689664 WMVXENCD.DLL
-a----        07-12-2019     15:22          30720 WofTasks.dll
-a----        07-12-2019     14:38          36352 WofUtil.dll
-a----        15-07-2024     15:47          44032 WordBreakers.dll
-a----        17-11-2023     23:49         105472 WorkFolders.exe
-a----        15-07-2024     15:49         893952 WorkfoldersControl.dll
-a----        07-12-2019     14:39         108544 WorkFoldersGPExt.dll
-a----        07-12-2019     14:39          61952 WorkFoldersRes.dll
-a----        15-07-2024     15:49         230400 WorkFoldersShell.dll
-a----        15-07-2024     15:49        2233320 workfolderssvc.dll
-a----        15-07-2024     15:46         349184 wosc.dll
-a----        17-11-2023     23:48         354904 wow64.dll
-a----        17-11-2023     23:48          22464 wow64cpu.dll
-a----        23-02-2024     23:39         533152 wow64win.dll
-a----        17-11-2023     23:49          17920 wowreg32.exe
-a----        17-11-2023     23:47         452608 WpAXHolder.dll
-a----        07-12-2019     14:38         103424 wpbcreds.dll
-a----        15-07-2024     15:46        1651200 Wpc.dll
-a----        15-07-2024     15:46         336896 WpcApi.dll
-a----        07-12-2019     14:38          10143 wpcatltoast.png
-a----        15-07-2024     15:46        1869824 WpcDesktopMonSvc.dll
-a----        15-07-2024     15:46        1188048 WpcMon.exe
-a----        07-12-2019     14:38           4687 wpcmon.png
-a----        15-07-2024     15:46          40960 WpcProxyStubs.dll
-a----        15-07-2024     15:46        1050624 WpcRefreshTask.dll
-a----        15-07-2024     15:46         289280 WpcTok.exe
-a----        15-07-2024     15:46         859136 WpcWebFilter.dll
-a----        17-11-2023     23:50         101888 wpdbusenum.dll
-a----        15-07-2024     15:46         232448 WpdMtp.dll
-a----        15-07-2024     15:46         161792 WpdMtpUS.dll
-a----        15-07-2024     15:49         636416 wpdshext.dll
-a----        17-11-2023     23:50          30720 WPDShextAutoplay.exe
-a----        17-11-2023     23:50          67072 WPDShServiceObj.dll
-a----        15-07-2024     15:49         385024 WPDSp.dll
-a----        17-11-2023     23:50         230912 wpd_ci.dll
-a----        15-07-2024     15:47        1400320 wpnapps.dll
-a----        15-07-2024     15:47         368640 wpnclient.dll
-a----        15-07-2024     15:47        1507840 wpncore.dll
-a----        07-12-2019     14:38          24064 wpninprc.dll
-a----        17-11-2023     23:49          22528 wpnpinst.exe
-a----        15-07-2024     15:47         650752 wpnprv.dll
-a----        15-07-2024     15:47         245760 wpnservice.dll
-a----        07-12-2019     14:38          37888 wpnsruprov.dll
-a----        15-07-2024     15:47          86016 WpnUserService.dll
-a----        07-12-2019     14:38          14848 WpPortingLibrary.dll
-a----        07-12-2019     14:38          11776 WppRecorderUM.dll
-a----        07-12-2019     14:38            724 wpr.config.xml
-a----        15-07-2024     15:47         321024 wpr.exe
-a----        17-11-2023     23:49         176128 WPTaskScheduler.dll
-a----        15-07-2024     15:46        1329632 wpx.dll
-a----        07-12-2019     02:59          11264 write.exe
-a----        07-12-2019     14:38           4608 ws2help.dll
-a----        17-11-2023     23:48         429408 ws2_32.dll
-a----        17-11-2023     23:47           9216 wscadminui.exe
-a----        17-11-2023     23:47         299192 wscapi.dll
-a----        17-11-2023     23:49         223744 wscinterop.dll
-a----        17-11-2023     23:47          28160 wscisvif.dll
-a----        07-12-2019     14:38          13824 WSClient.dll
-a----        17-11-2023     23:48          95232 WSCollect.exe
-a----        17-11-2023     23:47          18944 wscproxystub.dll
-a----        15-07-2024     15:47         196608 wscript.exe
-a----        15-07-2024     15:46         354904 wscsvc.dll
-a----        17-11-2023     23:49          84992 wscui.cpl
-a----        15-07-2024     15:47         692736 WSDApi.dll
-a----        15-07-2024     15:48          57344 wsdchngr.dll
-a----        17-11-2023     23:49          92672 WSDPrintProxy.DLL
-a----        29-10-2023     08:36          24576 WsdProviderUtil.dll
-a----        17-11-2023     23:49          70656 WSDScanProxy.dll
-a----        15-07-2024     15:46         276992 WSDScDrv.dll
-a----        17-11-2023     23:49         706048 wsecedit.dll
-a----        15-07-2024     15:47          89088 wsepno.dll
-a----        17-11-2023     23:48          64000 wshbth.dll
-a----        29-10-2023     08:36          25088 wshcon.dll
-a----        07-12-2019     14:38          23040 wshelper.dll
-a----        29-10-2023     08:36         103424 wshext.dll
-a----        17-11-2023     23:49          19768 wshhyperv.dll
-a----        17-11-2023     23:48          12800 wship6.dll
-a----        29-10-2023     08:36         147456 wshom.ocx
-a----        17-11-2023     23:48          20480 wshqos.dll
-a----        15-07-2024     15:48          18944 wshrm.dll
-a----        17-11-2023     23:48          12800 WSHTCPIP.DLL
-a----        07-12-2019     14:39          17560 wshunix.dll
-a----        15-07-2024     15:49         172544 wsl.exe
-a----        15-07-2024     15:49         291840 wslapi.dll
-a----        15-07-2024     15:49          91136 wslconfig.exe
-a----        17-11-2023     23:48          32768 WsmAgent.dll
-a----        07-12-2019     14:38           4675 wsmanconfig_schema.xml
-a----        17-11-2023     23:48          43008 WSManHTTPConfig.exe
-a----        17-11-2023     23:48          88576 WSManMigrationPlugin.dll
-a----        17-11-2023     23:48         180224 WsmAuto.dll
-a----        17-11-2023     23:48          16384 wsmplpxy.dll
-a----        17-11-2023     23:48          46592 wsmprovhost.exe
-a----        07-12-2019     14:38           1559 WsmPty.xsl
-a----        17-11-2023     23:48          61952 WsmRes.dll
-a----        15-07-2024     15:47        2812416 WsmSvc.dll
-a----        07-12-2019     14:38           2426 WsmTxt.xsl
-a----        17-11-2023     23:48         322048 WsmWmiPl.dll
-a----        07-12-2019     14:38          66048 wsnmp32.dll
-a----        07-12-2019     14:38          18944 wsock32.dll
-a----        07-12-2019     14:39          45568 wsplib.dll
-a----        15-07-2024     15:48        2025344 wsp_fs.dll
-a----        15-07-2024     15:48        1763312 wsp_health.dll
-a----        07-12-2019     14:39         965944 wsp_sr.dll
-a----        15-07-2024     15:47         120320 wsqmcons.exe
-a----        17-11-2023     23:48          94208 WSReset.exe
-a----        07-12-2019     14:39          95232 WSTPager.ax
-a----        17-11-2023     23:49          68368 wtsapi32.dll
-a----        15-07-2024     15:47         956416 wuapi.dll
-a----        17-11-2023     23:48          11264 wuapihost.exe
-a----        15-07-2024     15:47          66760 wuauclt.exe
-a----        15-07-2024     15:47        3436032 wuaueng.dll
-a----        15-07-2024     15:47         246784 wuceffects.dll
-a----        07-12-2019     14:38          51200 WUDFCoinstaller.dll
-a----        20-01-2024     11:02         161872 WUDFCompanionHost.exe
-a----        20-01-2024     11:02         270336 WUDFHost.exe
-a----        20-01-2024     11:02         196952 WUDFPlatform.dll
-a----        07-12-2019     14:39          55808 WudfSMCClassExt.dll
-a----        17-11-2023     23:49         595456 WUDFx.dll
-a----        15-07-2024     15:47         764968 WUDFx02000.dll
-a----        15-07-2024     15:47         127488 wudriver.dll
-a----        15-07-2024     15:47          85504 wups.dll
-a----        15-07-2024     15:47          64000 wups2.dll
-a----        15-07-2024     15:46         345088 wusa.exe
-a----        15-07-2024     15:47         525824 wuuhext.dll
-a----        15-07-2024     15:47         267776 wuuhosdeployment.dll
-a----        29-10-2023     08:37         580096 wvc.dll
-a----        15-07-2024     15:47         569344 WwaApi.dll
-a----        15-07-2024     15:47          40960 WwaExt.dll
-a----        15-07-2024     15:47         996224 WWAHost.exe
-a----        17-11-2023     23:47         579640 WWanAPI.dll
-a----        07-12-2019     14:39         105472 wwancfg.dll
-a----        15-07-2024     15:48         506880 wwanconn.dll
-a----        17-11-2023     23:49          73216 WWanHC.dll
-a----        15-07-2024     15:48         553472 wwanmm.dll
-a----        17-11-2023     23:49          52736 Wwanpref.dll
-a----        17-11-2023     23:47         112128 wwanprotdim.dll
-a----        15-07-2024     15:48          91648 WwanRadioManager.dll
-a----        15-07-2024     15:46        1517056 wwansvc.dll
-a----        17-11-2023     23:47          98792 wwapi.dll
-a----        15-07-2024     15:46         234496 XamlTileRender.dll
-a----        07-12-2019     14:38           3584 XAudio2_8.dll
-a----        15-07-2024     15:46         638976 XAudio2_9.dll
-a----        15-07-2024     15:46        1049088 XblAuthManager.dll
-a----        17-11-2023     23:47          93696 XblAuthManagerProxy.dll
-a----        15-07-2024     15:46         114688 XblAuthTokenBrokerExt.dll
-a----        15-07-2024     15:46        1291264 XblGameSave.dll
-a----        15-07-2024     15:46         159744 XblGameSaveExt.dll
-a----        15-07-2024     15:46          33792 XblGameSaveTask.exe
-a----        15-07-2024     15:46          72704 xboxgipsvc.dll
-a----        17-11-2023     23:49        1295360 XboxNetApiSvc.dll
-a----        17-11-2023     23:49          45568 XInput1_4.dll
-a----        15-07-2024     15:46          49664 XInputUap.dll
-a----        17-11-2023     23:48         216440 xmllite.dll
-a----        15-07-2024     15:48         109056 xolehlp.dll
-a----        17-11-2023     23:50         820224 XpsFilt.dll
-a----        15-07-2024     15:47         456192 XpsGdiConverter.dll
-a----        15-07-2024     15:47        1515008 XpsPrint.dll
-a----        15-07-2024     15:47         379392 xpspushlayer.dll
-a----        17-11-2023     23:49         581120 XpsRasterService.dll
-a----        16-10-2019     03:23          76060 xpsrchvw.xml
-a----        23-02-2024     23:41        2844672 xpsservices.dll
-a----        17-11-2023     23:50         104960 XPSSHHDR.dll
-a----        15-07-2024     15:47         268288 XpsToPclmConverter.dll
-a----        15-07-2024     15:47          78336 XpsToPwgrConverter.dll
-a----        07-12-2019     14:39          64000 xwizard.exe
-a----        17-11-2023     23:49         452608 xwizards.dll
-a----        17-11-2023     23:49         121344 xwreg.dll
-a----        17-11-2023     23:49         267776 xwtpdui.dll
-a----        07-12-2019     14:38            627 X_80.contrast-black.png
-a----        07-12-2019     14:38            627 X_80.png
-a----        02-08-2021     19:21         376136 ze_loader.dll
-a----        02-08-2021     19:21         459080 ze_tracing_layer.dll
-a----        02-08-2021     19:21         148280 ze_validation_layer.dll
-a----        15-07-2024     15:47         302592 zipfldr.dll
-a----        07-12-2019     14:38          30720 ztrace_maps.dll


error: no objects passed to apply
PS C:\windows\system32> kubectl apply -f nginx-deployment.yaml
error: no objects passed to apply
PS C:\windows\system32> kubectl apply -f ./nginx-deployment.yaml
error: no objects passed to apply
PS C:\windows\system32> kubectl apply -f .\nginx-deployment.yaml
error: no objects passed to apply
PS C:\windows\system32> kubectl apply -f .\nginx-deployment.yaml
PS C:\windows\system32> kubectl apply -f C:\nginx\nginx-deployment.yaml
deployment.apps/nginx-deployment created
PS C:\windows\system32> kubectl exec -it mongo-depl-887485654-qjj6d -- bin/bash
root@mongo-depl-887485654-qjj6d:/# kubectl apply -f nginx-deployment.yaml
bash: kubectl: command not found
root@mongo-depl-887485654-qjj6d:/# exit
exit
PS C:\windows\system32> kubectl get pod
mongo-depl-887485654-qjj6d          1/1     Running   0          34m
nginx-deployment-77d8468669-jmhxr   1/1     Running   0          3m40s
PS C:\windows\system32> kubectl get deployment
NAME               READY   UP-TO-DATE   AVAILABLE   AGE
mongo-depl         1/1     1            1           35m
nginx-depl         1/1     1            1           47m
nginx-deployment   2/2     2            2           4m23s
PS C:\windows\system32> kubectl apply -f C:\nginx\nginx-deployment.yaml
deployment.apps/nginx-deployment configured
PS C:\windows\system32> kubectl get pod
NAME                                READY   STATUS    RESTARTS   AGE
mongo-depl-887485654-qjj6d          1/1     Running   0          36m
nginx-depl-85c9d7c5f4-tsvlq         1/1     Running   0          48m
nginx-deployment-77d8468669-jmhxr   1/1     Running   0          5m39s
PS C:\windows\system32> kubectl get deployment
mongo-depl         1/1     1            1           36m
nginx-deployment   1/1     1            1           5m49s
PS C:\windows\system32> echo -n 'username' | base64
the path is correct and try again.
+ echo -n 'username' | base64
+                      ~~~~~~
    + CategoryInfo          : ObjectNotFound: (base64:String) [], CommandNotFoundException
    + FullyQualifiedErrorId : CommandNotFoundException

PS C:\windows\system32> $bytes = [System.Text.Encoding]::UTF8.GetBytes($string)
PS C:\windows\system32> $base64 = [Convert]::ToBase64String($bytes)$base64 = [Convert]::ToBase64String($bytes)
At line:1 char:44
+ $base64 = [Convert]::ToBase64String($bytes)$base64 = [Convert]::ToBas ...
+                                            ~~~~~~~
Unexpected token '$base64' in expression or statement.
    + CategoryInfo          : ParserError: (:) [], ParentContainsErrorRecordException
    + FullyQualifiedErrorId : UnexpectedToken

PS C:\windows\system32> [Convert]::ToBase64String([System.Text.Encoding]::UTF8.GetBytes("username"))
dXNlcm5hbWU=
PS C:\windows\system32> [Convert]::ToBase64String([System.Text.Encoding]::UTF8.GetBytes("password"))
cGFzc3dvcmQ=
PS C:\windows\system32> cd C:\nginx
PS C:\nginx> dir


    Directory: C:\nginx


----                 -------------         ------ ----
-a----        09-08-2024     16:22            162 mongo-secret.yaml
-a----        09-08-2024     16:13            486 mongo.yaml
-a----        09-08-2024     15:56            335 nginx-deployment.yaml
-a----        09-08-2024     16:21            162 secret.yaml

PS C:\nginx> kubectl apply -f mongo-secret.yaml
secret/mongodb-secret created
PS C:\nginx> kubectl get secret
NAME             TYPE     DATA   AGE
mongodb-secret   Opaque   2      39s
deployment.apps/mongodb-deployment created
PS C:\nginx> kubectl get deployment
NAME                 READY   UP-TO-DATE   AVAILABLE   AGE
mongo-depl           1/1     1            1           69m
mongodb-deployment   0/1     1            0           18s
nginx-depl           1/1     1            1           81m
nginx-deployment     1/1     1            1           38m
PS C:\nginx> kubectl get all
NAME                                      READY   STATUS         RESTARTS   AGE
pod/mongo-depl-887485654-qjj6d            1/1     Running        0          69m
pod/mongodb-deployment-7bc58f8b5f-pkp8b   0/1     ErrImagePull   0          51s
pod/nginx-depl-85c9d7c5f4-tsvlq           1/1     Running        0          81m
pod/nginx-deployment-77d8468669-jmhxr     1/1     Running        0          38m

NAME                 TYPE        CLUSTER-IP   EXTERNAL-IP   PORT(S)   AGE
service/kubernetes   ClusterIP   10.96.0.1    <none>        443/TCP   11d

NAME                                 READY   UP-TO-DATE   AVAILABLE   AGE
deployment.apps/mongo-depl           1/1     1            1           69m
deployment.apps/mongodb-deployment   0/1     1            0           51s
deployment.apps/nginx-depl           1/1     1            1           81m

NAME                                            DESIRED   CURRENT   READY   AGE
replicaset.apps/mongo-depl-887485654            1         1         1       69m
replicaset.apps/mongodb-deployment-7bc58f8b5f   1         1         0       51s
replicaset.apps/nginx-depl-85c9d7c5f4           1         1         1       81m
replicaset.apps/nginx-deployment-77d8468669     1         1         1       38m
PS C:\nginx> kubectl get pod
NAME                                  READY   STATUS         RESTARTS   AGE
mongo-depl-887485654-qjj6d            1/1     Running        0          71m
mongodb-deployment-7bc58f8b5f-pkp8b   0/1     ErrImagePull   0          2m17s
nginx-depl-85c9d7c5f4-tsvlq           1/1     Running        0          83m
nginx-deployment-77d8468669-jmhxr     1/1     Running        0          40m
PS C:\nginx> kubectl apply -f mongo.yaml
deployment.apps/mongodb-deployment configured
PS C:\nginx> kubectl get pod
NAME                                  READY   STATUS    RESTARTS   AGE
mongo-depl-887485654-qjj6d            1/1     Running   0          75m
mongodb-deployment-74788c5c54-98pjh   1/1     Running   0          9s
nginx-depl-85c9d7c5f4-tsvlq           1/1     Running   0          87m
nginx-deployment-77d8468669-jmhxr     1/1     Running   0          44m
PS C:\nginx> kubectl get all
NAME                                      READY   STATUS    RESTARTS   AGE
pod/mongo-depl-887485654-qjj6d            1/1     Running   0          75m
pod/mongodb-deployment-74788c5c54-98pjh   1/1     Running   0          17s
pod/nginx-depl-85c9d7c5f4-tsvlq           1/1     Running   0          87m
pod/nginx-deployment-77d8468669-jmhxr     1/1     Running   0          44m

NAME                 TYPE        CLUSTER-IP   EXTERNAL-IP   PORT(S)   AGE
service/kubernetes   ClusterIP   10.96.0.1    <none>        443/TCP   11d

NAME                                 READY   UP-TO-DATE   AVAILABLE   AGE
deployment.apps/mongo-depl           1/1     1            1           75m
deployment.apps/mongodb-deployment   1/1     1            1           6m50s
deployment.apps/nginx-depl           1/1     1            1           87m
deployment.apps/nginx-deployment     1/1     1            1           44m

NAME                                            DESIRED   CURRENT   READY   AGE
replicaset.apps/mongo-depl-887485654            1         1         1       75m
replicaset.apps/mongodb-deployment-74788c5c54   1         1         1       17s
replicaset.apps/mongodb-deployment-7bc58f8b5f   0         0         0       6m50s
replicaset.apps/nginx-depl-85c9d7c5f4           1         1         1       87m
replicaset.apps/nginx-deployment-77d8468669     1         1         1       44m
PS C:\nginx> kubectl get pod
NAME                                  READY   STATUS    RESTARTS   AGE
mongo-depl-887485654-qjj6d            1/1     Running   0          76m
mongodb-deployment-74788c5c54-98pjh   1/1     Running   0          71s
nginx-depl-85c9d7c5f4-tsvlq           1/1     Running   0          88m
nginx-deployment-77d8468669-jmhxr     1/1     Running   0          45m
PS C:\nginx>

PS C:\nginx> minikube start
* minikube v1.33.1 on Microsoft Windows 10 Home Single Language 10.0.19045.4651 Build 19045.4651
* Using the docker driver based on existing profile
* Starting "minikube" primary control-plane node in "minikube" cluster
* Pulling base image v0.0.44 ...
* Restarting existing docker container for "minikube" ...
* Preparing Kubernetes v1.30.0 on Docker 26.1.1 ...
* Verifying Kubernetes components...
  - Using image gcr.io/k8s-minikube/storage-provisioner:v5
* Enabled addons: default-storageclass, storage-provisioner
* Done! kubectl is now configured to use "minikube" cluster and "default" namespace by default
PS C:\nginx> kubectl get pod
NAME                                  READY   STATUS    RESTARTS      AGE
mongo-depl-887485654-qjj6d            0/1     Error     0             34h
mongodb-deployment-74788c5c54-98pjh   1/1     Running   1 (26s ago)   32h
nginx-depl-85c9d7c5f4-tsvlq           1/1     Running   1 (26s ago)   34h
nginx-deployment-77d8468669-jmhxr     1/1     Running   1 (26s ago)   33h
PS C:\nginx> kubectl get deployment
NAME                 READY   UP-TO-DATE   AVAILABLE   AGE
mongo-depl           1/1     1            1           34h
mongodb-deployment   1/1     1            1           33h
nginx-depl           1/1     1            1           34h
nginx-deployment     1/1     1            1           33h
PS C:\nginx> kubectl apply -f mongo.yaml
deployment.apps/mongodb-deployment unchanged
error: resource mapping not found for name: "mongodb-service" namespace: "" from "mongo.yaml": no matches for kind "Service" in version "apps/v1"
ensure CRDs are installed first
PS C:\nginx> kubectl apply -f mongo.yaml
deployment.apps/mongodb-deployment unchanged
Error from server (BadRequest): error when creating "mongo.yaml": Service in version "v1" cannot be handled as a Service: strict decoding error: unknown field "spec.ports[0].ports"
PS C:\nginx> kubectl apply -f mongo.yaml
deployment.apps/mongodb-deployment unchanged
service/mongodb-service created
PS C:\nginx> kubectl get service
NAME              TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)     AGE
kubernetes        ClusterIP   10.96.0.1       <none>        443/TCP     12d
mongodb-service   ClusterIP   10.96.113.154   <none>        27017/TCP   2m4s
PS C:\nginx> kubectl get deployment
NAME                 READY   UP-TO-DATE   AVAILABLE   AGE
mongo-depl           1/1     1            1           34h
mongodb-deployment   1/1     1            1           33h
nginx-depl           1/1     1            1           34h
nginx-deployment     1/1     1            1           33h
PS C:\nginx> kubectl describe service mongodb-service
Name:              mongodb-service
Namespace:         default
Labels:            <none>
Annotations:       <none>
Selector:          app=mongodb
Type:              ClusterIP
IP Family Policy:  SingleStack
IP Families:       IPv4
IP:                10.96.113.154
IPs:               10.96.113.154
Port:              <unset>  27017/TCP
TargetPort:        27017/TCP
Endpoints:         10.244.0.13:27017
Session Affinity:  None
Events:            <none>
PS C:\nginx> kubectl get pod -o wide
NAME                                  READY   STATUS    RESTARTS        AGE   IP            NODE       NOMINATED NODE   READINESS GATES
mongo-depl-887485654-qjj6d            1/1     Running   1 (7m40s ago)   34h   10.244.0.14   minikube   <none>           <none>
mongodb-deployment-74788c5c54-98pjh   1/1     Running   1 (7m40s ago)   33h   10.244.0.13   minikube   <none>           <none>
nginx-depl-85c9d7c5f4-tsvlq           1/1     Running   1 (7m40s ago)   34h   10.244.0.12   minikube   <none>           <none>
nginx-deployment-77d8468669-jmhxr     1/1     Running   1 (7m40s ago)   33h   10.244.0.11   minikube   <none>           <none>
PS C:\nginx> kubectl apply -f mongo-configmap.yaml
configmap/mongodb-configmap created
PS C:\nginx> kubectl apply -f mongo-express.yaml
deployment.apps/mongo-express created
PS C:\nginx> kubectl get all
NAME                                      READY   STATUS              RESTARTS      AGE
pod/mongo-depl-887485654-qjj6d            1/1     Running             1 (25m ago)   34h
pod/mongo-express-7c54c57c6c-d9rwg        0/1     ContainerCreating   0             58s
pod/mongodb-deployment-74788c5c54-98pjh   1/1     Running             1 (25m ago)   33h
pod/nginx-depl-85c9d7c5f4-tsvlq           1/1     Running             1 (25m ago)   34h
pod/nginx-deployment-77d8468669-jmhxr     1/1     Running             1 (25m ago)   34h

NAME                      TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)     AGE
service/kubernetes        ClusterIP   10.96.0.1       <none>        443/TCP     12d
service/mongodb-service   ClusterIP   10.96.113.154   <none>        27017/TCP   21m

NAME                                 READY   UP-TO-DATE   AVAILABLE   AGE
deployment.apps/mongo-depl           1/1     1            1           34h
deployment.apps/mongo-express        0/1     1            0           58s
deployment.apps/mongodb-deployment   1/1     1            1           33h
deployment.apps/nginx-depl           1/1     1            1           34h
deployment.apps/nginx-deployment     1/1     1            1           34h

NAME                                            DESIRED   CURRENT   READY   AGE
replicaset.apps/mongo-depl-887485654            1         1         1       34h
replicaset.apps/mongo-express-7c54c57c6c        1         1         0       58s
replicaset.apps/mongodb-deployment-74788c5c54   1         1         1       33h
replicaset.apps/mongodb-deployment-7bc58f8b5f   0         0         0       33h
replicaset.apps/nginx-depl-85c9d7c5f4           1         1         1       34h
replicaset.apps/nginx-deployment-77d8468669     1         1         1       34h
PS C:\nginx> kubectl get deployment
NAME                 READY   UP-TO-DATE   AVAILABLE   AGE
mongo-depl           1/1     1            1           34h
mongo-express        0/1     1            0           81s
mongodb-deployment   1/1     1            1           33h
nginx-depl           1/1     1            1           34h
nginx-deployment     1/1     1            1           34h
PS C:\nginx> kubectl get pod -o wide
NAME                                  READY   STATUS                       RESTARTS      AGE   IP            NODE       NOMINATED NODE   READINESS GATES
mongo-depl-887485654-qjj6d            1/1     Running                      1 (25m ago)   34h   10.244.0.14   minikube   <none>           <none>
mongo-express-7c54c57c6c-d9rwg        0/1     CreateContainerConfigError   0             89s   10.244.0.15   minikube   <none>           <none>
mongodb-deployment-74788c5c54-98pjh   1/1     Running                      1 (25m ago)   33h   10.244.0.13   minikube   <none>           <none>
nginx-depl-85c9d7c5f4-tsvlq           1/1     Running                      1 (25m ago)   34h   10.244.0.12   minikube   <none>           <none>
nginx-deployment-77d8468669-jmhxr     1/1     Running                      1 (25m ago)   34h   10.244.0.11   minikube   <none>           <none>
PS C:\nginx> kubectl get pod
NAME                                  READY   STATUS                       RESTARTS      AGE
mongo-depl-887485654-qjj6d            1/1     Running                      1 (26m ago)   34h
mongo-express-7c54c57c6c-d9rwg        0/1     CreateContainerConfigError   0             2m
mongodb-deployment-74788c5c54-98pjh   1/1     Running                      1 (26m ago)   33h
nginx-depl-85c9d7c5f4-tsvlq           1/1     Running                      1 (26m ago)   34h
nginx-deployment-77d8468669-jmhxr     1/1     Running                      1 (26m ago)   34h
PS C:\nginx> kubectl apply -f mongo-express.yaml
deployment.apps/mongo-express configured
PS C:\nginx> kubectl get pod
NAME                                  READY   STATUS                       RESTARTS      AGE
mongo-depl-887485654-qjj6d            1/1     Running                      1 (29m ago)   34h
mongo-express-7c54c57c6c-d9rwg        0/1     CreateContainerConfigError   0             4m44s
mongo-express-854966995b-t2kpr        0/1     CreateContainerConfigError   0             9s
mongodb-deployment-74788c5c54-98pjh   1/1     Running                      1 (29m ago)   33h
nginx-depl-85c9d7c5f4-tsvlq           1/1     Running                      1 (29m ago)   34h
nginx-deployment-77d8468669-jmhxr     1/1     Running                      1 (29m ago)   34h
PS C:\nginx> kubectl apply -f mongo-express.yaml
deployment.apps/mongo-express configured
PS C:\nginx> kubectl get deployment
NAME                 READY   UP-TO-DATE   AVAILABLE   AGE
mongo-depl           1/1     1            1           34h
mongo-express        0/1     1            0           9m40s
mongodb-deployment   1/1     1            1           33h
nginx-depl           1/1     1            1           34h
nginx-deployment     1/1     1            1           34h
PS C:\nginx> kubectl get pod
NAME                                  READY   STATUS                       RESTARTS      AGE
mongo-depl-887485654-qjj6d            1/1     Running                      1 (34m ago)   34h
mongo-express-59444895cd-mf6q9        0/1     CreateContainerConfigError   0             13s
mongo-express-854966995b-t2kpr        0/1     CreateContainerConfigError   0             5m12s
mongodb-deployment-74788c5c54-98pjh   1/1     Running                      1 (34m ago)   33h
nginx-depl-85c9d7c5f4-tsvlq           1/1     Running                      1 (34m ago)   34h
nginx-deployment-77d8468669-jmhxr     1/1     Running                      1 (34m ago)   34h
PS C:\nginx> kubectl logs mongo-express-854966995b-t2kpr
Error from server (BadRequest): container "mongo-express" in pod "mongo-express-854966995b-t2kpr" is waiting to start: CreateContainerConfigError
PS C:\nginx> kubectl logs mongo-express-59444895cd-mf6q9
Error from server (BadRequest): container "mongo-express" in pod "mongo-express-59444895cd-mf6q9" is waiting to start: CreateContainerConfigError
PS C:\nginx> kubectl apply -f mongo-express.yaml
deployment.apps/mongo-express configured
PS C:\nginx> kubectl get pods
NAME                                  READY   STATUS    RESTARTS      AGE
mongo-depl-887485654-qjj6d            1/1     Running   1 (36m ago)   34h
mongo-express-f56d5b7ff-n8rpn         1/1     Running   0             7s
mongodb-deployment-74788c5c54-98pjh   1/1     Running   1 (36m ago)   33h
nginx-depl-85c9d7c5f4-tsvlq           1/1     Running   1 (36m ago)   34h
nginx-deployment-77d8468669-jmhxr     1/1     Running   1 (36m ago)   34h
PS C:\nginx> kubectl get pod
NAME                                  READY   STATUS    RESTARTS      AGE
mongo-depl-887485654-qjj6d            1/1     Running   1 (36m ago)   34h
mongo-express-f56d5b7ff-n8rpn         1/1     Running   0             29s
mongodb-deployment-74788c5c54-98pjh   1/1     Running   1 (36m ago)   33h
nginx-depl-85c9d7c5f4-tsvlq           1/1     Running   1 (36m ago)   34h
nginx-deployment-77d8468669-jmhxr     1/1     Running   1 (36m ago)   34h
PS C:\nginx> kubectl get deployment
NAME                 READY   UP-TO-DATE   AVAILABLE   AGE
mongo-depl           1/1     1            1           34h
mongo-express        1/1     1            1           12m
mongodb-deployment   1/1     1            1           33h
nginx-depl           1/1     1            1           34h
nginx-deployment     1/1     1            1           34h
PS C:\nginx> kubectl logs mongo-express-f56d5b7ff-n8rpn
Waiting for mongo:27017...
/docker-entrypoint.sh: line 15: mongo: Try again
/docker-entrypoint.sh: line 15: /dev/tcp/mongo/27017: Invalid argument
Sat Aug 10 20:36:18 UTC 2024 retrying to connect to mongo:27017 (2/10)
/docker-entrypoint.sh: line 15: mongo: Try again
/docker-entrypoint.sh: line 15: /dev/tcp/mongo/27017: Invalid argument
Sat Aug 10 20:36:24 UTC 2024 retrying to connect to mongo:27017 (3/10)
/docker-entrypoint.sh: line 15: mongo: Try again
/docker-entrypoint.sh: line 15: /dev/tcp/mongo/27017: Invalid argument
Sat Aug 10 20:36:30 UTC 2024 retrying to connect to mongo:27017 (4/10)
/docker-entrypoint.sh: line 15: mongo: Try again
/docker-entrypoint.sh: line 15: /dev/tcp/mongo/27017: Invalid argument
Sat Aug 10 20:36:36 UTC 2024 retrying to connect to mongo:27017 (5/10)
/docker-entrypoint.sh: line 15: mongo: Try again
/docker-entrypoint.sh: line 15: /dev/tcp/mongo/27017: Invalid argument
Sat Aug 10 20:36:42 UTC 2024 retrying to connect to mongo:27017 (6/10)
/docker-entrypoint.sh: line 15: mongo: Try again
/docker-entrypoint.sh: line 15: /dev/tcp/mongo/27017: Invalid argument
Sat Aug 10 20:36:48 UTC 2024 retrying to connect to mongo:27017 (7/10)
/docker-entrypoint.sh: line 15: mongo: Try again
/docker-entrypoint.sh: line 15: /dev/tcp/mongo/27017: Invalid argument
Sat Aug 10 20:36:54 UTC 2024 retrying to connect to mongo:27017 (8/10)
/docker-entrypoint.sh: line 15: mongo: Try again
/docker-entrypoint.sh: line 15: /dev/tcp/mongo/27017: Invalid argument
Sat Aug 10 20:37:00 UTC 2024 retrying to connect to mongo:27017 (9/10)
/docker-entrypoint.sh: line 15: mongo: Try again
/docker-entrypoint.sh: line 15: /dev/tcp/mongo/27017: Invalid argument
Sat Aug 10 20:37:06 UTC 2024 retrying to connect to mongo:27017 (10/10)
/docker-entrypoint.sh: line 15: mongo: Try again
/docker-entrypoint.sh: line 15: /dev/tcp/mongo/27017: Invalid argument
No custom config.js found, loading config.default.js
Welcome to mongo-express 1.0.2
------------------------


Mongo Express server listening at http://0.0.0.0:8081
←[31mServer is open to allow connections from anyone (0.0.0.0)←[39m
←[31mbasicAuth credentials are "admin:pass", it is recommended you change this in your config.js!←[39m
PS C:\nginx> kubectl apply -f mongo-express.yaml
deployment.apps/mongo-express unchanged
service/mongo-express-service created
PS C:\nginx> kubectl get service
NAME                    TYPE           CLUSTER-IP      EXTERNAL-IP   PORT(S)          AGE
kubernetes              ClusterIP      10.96.0.1       <none>        443/TCP          12d
mongo-express-service   LoadBalancer   10.98.5.83      <pending>     8081:30000/TCP   11s
mongodb-service         ClusterIP      10.96.113.154   <none>        27017/TCP        38m
PS C:\nginx> minikube service mongo-express-service
|-----------|-----------------------|-------------|---------------------------|
| NAMESPACE |         NAME          | TARGET PORT |            URL            |
|-----------|-----------------------|-------------|---------------------------|
| default   | mongo-express-service |        8081 | http://192.168.49.2:30000 |
|-----------|-----------------------|-------------|---------------------------|
* Starting tunnel for service mongo-express-service.
|-----------|-----------------------|-------------|------------------------|
| NAMESPACE |         NAME          | TARGET PORT |          URL           |
|-----------|-----------------------|-------------|------------------------|
| default   | mongo-express-service |             | http://127.0.0.1:49995 |
|-----------|-----------------------|-------------|------------------------|
* Opening service default/mongo-express-service in default browser...
! Because you are using a Docker driver on windows, the terminal needs to be open to run it.
* Stopped tunnel for service mongo-express-service.
PS C:\nginx> kubectl describe service mongo-express-service
Name:                     mongo-express-service
Namespace:                default
Labels:                   <none>
Annotations:              <none>
Selector:                 app=mongo-express
Type:                     LoadBalancer
IP Family Policy:         SingleStack
IP Families:              IPv4
IP:                       10.98.5.83
IPs:                      10.98.5.83
Port:                     <unset>  8081/TCP
TargetPort:               8081/TCP
NodePort:                 <unset>  30000/TCP
Endpoints:                10.244.0.18:8081
Session Affinity:         None
External Traffic Policy:  Cluster
Events:                   <none>
PS C:\nginx> kubectl describe service mongo-express-service
Name:                     mongo-express-service
Namespace:                default
Labels:                   <none>
Annotations:              <none>
Selector:                 app=mongo-express
Type:                     LoadBalancer
IP Family Policy:         SingleStack
IP Families:              IPv4
IP:                       10.98.5.83
IPs:                      10.98.5.83
LoadBalancer Ingress:     127.0.0.1
Port:                     <unset>  8081/TCP
TargetPort:               8081/TCP
NodePort:                 <unset>  30000/TCP
Endpoints:                10.244.0.18:8081
Session Affinity:         None
External Traffic Policy:  Cluster
Events:                   <none>
PS C:\nginx> kubectl apply -f mongo-express.yaml
deployment.apps/mongo-express unchanged
service/mongo-express-service configured
PS C:\nginx> kubectl get service
NAME                    TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)          AGE
kubernetes              ClusterIP   10.96.0.1       <none>        443/TCP          12d
mongo-express-service   NodePort    10.98.5.83      <none>        8081:30000/TCP   14m
mongodb-service         ClusterIP   10.96.113.154   <none>        27017/TCP        52m
PS C:\nginx> minikube service mongo-express-service
|-----------|-----------------------|-------------|---------------------------|
| NAMESPACE |         NAME          | TARGET PORT |            URL            |
|-----------|-----------------------|-------------|---------------------------|
| default   | mongo-express-service |        8081 | http://192.168.49.2:30000 |
|-----------|-----------------------|-------------|---------------------------|
* Starting tunnel for service mongo-express-service.
|-----------|-----------------------|-------------|------------------------|
| NAMESPACE |         NAME          | TARGET PORT |          URL           |
|-----------|-----------------------|-------------|------------------------|
| default   | mongo-express-service |             | http://127.0.0.1:50256 |
|-----------|-----------------------|-------------|------------------------|
* Opening service default/mongo-express-service in default browser...
! Because you are using a Docker driver on windows, the terminal needs to be open to run it.

If you're seeing a "refused to connect" error when trying to access the Mongo Express web interface, it usually indicates that there's a problem with the service setup or how it's being exposed. Here are some steps to troubleshoot and resolve the issue:

### 1. Verify Service Status

Make sure the `mongo-express` service and pods are running correctly.

```sh
kubectl get services
kubectl get pods
```

Check if the `mongo-express` pod is in the `Running` state and if the `mongo-express-service` has an appropriate endpoint.

### 2. Check Pod Logs

Inspect the logs of the `mongo-express` pod for any errors or warnings that might explain why it's not reachable.

```sh
kubectl logs <mongo-express-pod-name>
```

Replace `<mongo-express-pod-name>` with the actual pod name of `mongo-express`.

### 3. Validate Service Configuration

Ensure that the `mongo-express-service` is properly configured and pointing to the correct ports.

```sh
kubectl describe service mongo-express-service
```

Verify that the service has the correct `ClusterIP`, `Port(s)`, and `TargetPort`.

### 4. Ensure Minikube Tunnel is Running

Since you are using Minikube, ensure that the Minikube tunnel is running properly. The tunnel creates a route from your local machine to the service in Minikube.

Start the Minikube tunnel in a separate terminal:

```sh
minikube tunnel
```

Keep this terminal open while you try to access the service.

### 5. Check Local Firewall and Proxy Settings

Ensure that no local firewall or proxy settings are blocking the port or connection.

- Check your firewall settings to make sure that traffic on port `49995` is allowed.
- Ensure no proxy settings are interfering with the connection.

### 6. Test Connectivity Inside Minikube

Exec into the `mongo-express` pod to check if the service is correctly accessible internally.

```sh
kubectl exec -it <mongo-express-pod-name> -- /bin/sh
```

Inside the pod, use tools like `curl` or `wget` to check connectivity to `localhost:8081`.

### 7. Validate Service Type

Check if the service type is correctly set as `LoadBalancer`. Sometimes, changing it to `NodePort` can help with local testing:

Update the service YAML:

```yaml
apiVersion: v1
kind: Service
metadata:
  name: mongo-express-service
spec:
  type: NodePort
  ports:
  - port: 8081
    targetPort: 8081
    nodePort: 30000
  selector:
    app: mongo-express
```

Apply the updated service configuration:

```sh
kubectl apply -f mongo-express-service.yaml
```

### 8. Use Minikube Service Command

Verify if `minikube service` provides the correct URL and if it reflects the current service state:

```sh
minikube service mongo-express-service --url
```

### Example Troubleshooting Commands

Here are commands to execute the above steps:

1. **Check Services and Pods**

   ```sh
   kubectl get services
   kubectl get pods
   ```

2. **Describe Service**

   ```sh
   kubectl describe service mongo-express-service
   ```

3. **Check Logs**

   ```sh
   kubectl logs <mongo-express-pod-name>
   ```

4. **Start Minikube Tunnel**

   ```sh
   minikube tunnel
   ```

5. **Check Connectivity Inside Pod**

   ```sh
   kubectl exec -it <mongo-express-pod-name> -- /bin/sh
   curl http://localhost:8081
   ```

6. **Update and Apply Service YAML**

   ```sh
   kubectl apply -f mongo-express-service.yaml
   ```

7. **Get Minikube Service URL**

   ```sh
   minikube service mongo-express-service --url
   ```

By following these troubleshooting steps, you should be able to identify and resolve the issue with accessing your `mongo-express` service.

The issue you're experiencing with the `LoadBalancer` type not working, but `NodePort` working, is often related to how Minikube and Kubernetes handle `LoadBalancer` services, especially in a local development environment. Here’s an explanation of why this might be happening and how `LoadBalancer` and `NodePort` services differ:

### `LoadBalancer` vs `NodePort`

1. **`LoadBalancer` Type:**
   - **Purpose:** Used in cloud environments (like AWS, GCP, Azure) to provision a cloud load balancer that routes external traffic to the service.
   - **Behavior:** Automatically assigns an external IP address that can be used to access the service from outside the cluster.
   - **Limitations in Local Development:**
     - **Minikube Limitations:** Minikube does not support provisioning a real cloud load balancer, which is why the `LoadBalancer` type does not work as expected in Minikube. Instead, Minikube uses a "fake" load balancer or tries to simulate this behavior, which can be unreliable.
     - **Pending External IP:** You might see the external IP as `<pending>` if Minikube cannot assign or simulate an external IP address.

2. **`NodePort` Type:**
   - **Purpose:** Exposes the service on a static port on each node's IP address. This allows access to the service from outside the cluster using `<node-ip>:<node-port>`.
   - **Behavior:** Works well in local environments because it does not require cloud load balancer functionality.
   - **Access:** You can directly access the service using `localhost:<node-port>` or `127.0.0.1:<node-port>` if using Minikube’s tunnel feature.

### Why `LoadBalancer` May Not Work in Minikube

- **Local Environment Limitations:** Minikube runs Kubernetes in a local VM or container, and does not have access to cloud provider load balancers. Therefore, it can't provision a real `LoadBalancer` like a cloud provider can.
- **Minikube Tunnel:** Minikube provides a way to access `LoadBalancer` services using the `minikube tunnel` command, but it’s not always reliable or straightforward. The tunnel command simulates the load balancer but may not always set up properly or might require additional configuration.

### Steps to Use `NodePort` Effectively

1. **Update Service Configuration:**

   Ensure your service YAML is correctly set up with `NodePort`:

   ```yaml
   apiVersion: v1
   kind: Service
   metadata:
     name: mongo-express-service
   spec:
     type: NodePort
     ports:
     - port: 8081
       targetPort: 8081
       nodePort: 30000
     selector:
       app: mongo-express
   ```

2. **Apply the Service:**

   ```sh
   kubectl apply -f mongo-express-service.yaml
   ```

3. **Access the Service:**

   Use Minikube to get the URL and access your service:

   ```sh
   minikube service mongo-express-service --url
   ```

4. **Check NodePort Service Directly:**

   If needed, you can manually access the service through the node IP and port. The node port is specified in the `nodePort` field (e.g., `30000`), and you can access it via:

   ```
   http://127.0.0.1:30000
   ```

### Conclusion

In summary, Minikube's lack of native `LoadBalancer` support is why switching to `NodePort` works in this environment. `NodePort` is generally more suitable for local development and testing scenarios with Minikube. For production deployments or cloud environments, `LoadBalancer` is the preferred choice.

Windows PowerShell
Copyright (C) Microsoft Corporation. All rights reserved.

Try the new cross-platform PowerShell https://aka.ms/pscore6

PS C:\Users\HP> kubectl get namespace
Unable to connect to the server: dial tcp 127.0.0.1:49452: connectex: No connection could be made because the target machine actively refused it.
PS C:\Users\HP> minikube start
* minikube v1.33.1 on Microsoft Windows 10 Home Single Language 10.0.19045.4651 Build 19045.4651
* Using the docker driver based on existing profile
* Starting "minikube" primary control-plane node in "minikube" cluster
* Pulling base image v0.0.44 ...
* Restarting existing docker container for "minikube" ...
* Preparing Kubernetes v1.30.0 on Docker 26.1.1 ...
* Verifying Kubernetes components...
  - Using image gcr.io/k8s-minikube/storage-provisioner:v5
* Enabled addons: storage-provisioner, default-storageclass
* Done! kubectl is now configured to use "minikube" cluster and "default" namespace by default
PS C:\Users\HP> kubectl get namespace
NAME              STATUS   AGE
default           Active   12d
kube-node-lease   Active   12d
kube-public       Active   12d
kube-system       Active   12d
PS C:\Users\HP> kubectl get dashboard
error: the server doesn't have a resource type "dashboard"
PS C:\Users\HP> kubectl cluster-info
Kubernetes control plane is running at https://127.0.0.1:51076
CoreDNS is running at https://127.0.0.1:51076/api/v1/namespaces/kube-system/services/kube-dns:dns/proxy

To further debug and diagnose cluster problems, use 'kubectl cluster-info dump'.
PS C:\Users\HP> kubectl create namespace my-namespace
namespace/my-namespace created
PS C:\Users\HP> minikube addons enable ingress
* ingress is an addon maintained by Kubernetes. For any concerns contact minikube on GitHub.
You can view the list of minikube maintainers at: https://github.com/kubernetes/minikube/blob/master/OWNERS
* After the addon is enabled, please run "minikube tunnel" and your ingress resources would be available at "127.0.0.1"
  - Using image registry.k8s.io/ingress-nginx/kube-webhook-certgen:v1.4.1
  - Using image registry.k8s.io/ingress-nginx/kube-webhook-certgen:v1.4.1
  - Using image registry.k8s.io/ingress-nginx/controller:v1.10.1
* Verifying ingress addon...
* The 'ingress' addon is enabled
PS C:\Users\HP> kubernet get pod
kubernet : The term 'kubernet' is not recognized as the name of a cmdlet, function, script
file, or operable program. Check the spelling of the name, or if a path was included,
verify that the path is correct and try again.
At line:1 char:1
+ kubernet get pod
+ ~~~~~~~~
    + CategoryInfo          : ObjectNotFound: (kubernet:String) [], CommandNotFoundExceptio
   n
    + FullyQualifiedErrorId : CommandNotFoundException

PS C:\Users\HP> kubectl get pod
NAME                                  READY   STATUS    RESTARTS      AGE
mongo-depl-887485654-qjj6d            1/1     Running   2 (29m ago)   39h
mongo-express-f56d5b7ff-n8rpn         1/1     Running   1 (29m ago)   4h24m
mongodb-deployment-74788c5c54-98pjh   1/1     Running   2 (29m ago)   37h
nginx-depl-85c9d7c5f4-tsvlq           1/1     Running   2 (29m ago)   39h
nginx-deployment-77d8468669-jmhxr     1/1     Running   2 (29m ago)   38h
PS C:\Users\HP> kubectl get namespace
NAME              STATUS   AGE
default           Active   12d
ingress-nginx     Active   2m29s
kube-node-lease   Active   12d
kube-public       Active   12d
kube-system       Active   12d
my-namespace      Active   27m
PS C:\Users\HP> kubectl get all
NAME                                      READY   STATUS    RESTARTS      AGE
pod/mongo-depl-887485654-qjj6d            1/1     Running   2 (30m ago)   39h
pod/mongo-express-f56d5b7ff-n8rpn         1/1     Running   1 (30m ago)   4h25m
pod/mongodb-deployment-74788c5c54-98pjh   1/1     Running   2 (30m ago)   37h
pod/nginx-depl-85c9d7c5f4-tsvlq           1/1     Running   2 (30m ago)   39h
pod/nginx-deployment-77d8468669-jmhxr     1/1     Running   2 (30m ago)   38h

NAME                            TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)          AGE
service/kubernetes              ClusterIP   10.96.0.1       <none>        443/TCP          12d
service/mongo-express-service   NodePort    10.98.5.83      <none>        8081:30000/TCP   4h20m
service/mongodb-service         ClusterIP   10.96.113.154   <none>        27017/TCP        4h57m

NAME                                 READY   UP-TO-DATE   AVAILABLE   AGE
deployment.apps/mongo-depl           1/1     1            1           39h
deployment.apps/mongo-express        1/1     1            1           4h37m
deployment.apps/mongodb-deployment   1/1     1            1           38h
deployment.apps/nginx-depl           1/1     1            1           39h
deployment.apps/nginx-deployment     1/1     1            1           38h

NAME                                            DESIRED   CURRENT   READY   AGE
replicaset.apps/mongo-depl-887485654            1         1         1       39h
replicaset.apps/mongo-express-59444895cd        0         0         0       4h27m
replicaset.apps/mongo-express-7c54c57c6c        0         0         0       4h37m
replicaset.apps/mongo-express-854966995b        0         0         0       4h32m
replicaset.apps/mongo-express-f56d5b7ff         1         1         1       4h25m
replicaset.apps/mongodb-deployment-74788c5c54   1         1         1       37h
replicaset.apps/mongodb-deployment-7bc58f8b5f   0         0         0       38h
replicaset.apps/nginx-depl-85c9d7c5f4           1         1         1       39h
replicaset.apps/nginx-deployment-77d8468669     1         1         1       38h
PS C:\Users\HP> kubectl get all -n kubernet-dashboard
No resources found in kubernet-dashboard namespace.
PS C:\Users\HP> kubectl get all --all-namespaces
NAMESPACE       NAME                                            READY   STATUS      RESTARTS      AGE
default         pod/mongo-depl-887485654-qjj6d                  1/1     Running     2 (32m ago)   39h
default         pod/mongo-express-f56d5b7ff-n8rpn               1/1     Running     1 (32m ago)   4h27m
default         pod/mongodb-deployment-74788c5c54-98pjh         1/1     Running     2 (32m ago)   37h
default         pod/nginx-depl-85c9d7c5f4-tsvlq                 1/1     Running     2 (32m ago)   39h
default         pod/nginx-deployment-77d8468669-jmhxr           1/1     Running     2 (32m ago)   38h
ingress-nginx   pod/ingress-nginx-admission-create-dcv7t        0/1     Completed   0             5m9s
ingress-nginx   pod/ingress-nginx-admission-patch-tjt24         0/1     Completed   1             5m9s
ingress-nginx   pod/ingress-nginx-controller-768f948f8f-9q4j6   1/1     Running     0             5m9s
kube-system     pod/coredns-7db6d8ff4d-hd89q                    1/1     Running     3 (32m ago)   12d
kube-system     pod/etcd-minikube                               1/1     Running     3 (32m ago)   12d
kube-system     pod/kube-apiserver-minikube                     1/1     Running     3 (32m ago)   12d
kube-system     pod/kube-controller-manager-minikube            1/1     Running     3 (32m ago)   12d
kube-system     pod/kube-proxy-tj7jr                            1/1     Running     3 (32m ago)   12d
kube-system     pod/kube-scheduler-minikube                     1/1     Running     3 (32m ago)   12d
kube-system     pod/storage-provisioner                         1/1     Running     7 (31m ago)   12d

NAMESPACE       NAME                                         TYPE        CLUSTER-IP       EXTERNAL-IP   PORT(S)                      AGE
default         service/kubernetes                           ClusterIP   10.96.0.1        <none>        443/TCP                      12d
default         service/mongo-express-service                NodePort    10.98.5.83       <none>        8081:30000/TCP               4h22m
default         service/mongodb-service                      ClusterIP   10.96.113.154    <none>        27017/TCP                    5h
ingress-nginx   service/ingress-nginx-controller             NodePort    10.105.178.233   <none>        80:30578/TCP,443:31655/TCP   5m9s
ingress-nginx   service/ingress-nginx-controller-admission   ClusterIP   10.100.84.166    <none>        443/TCP                      5m9s
kube-system     service/kube-dns                             ClusterIP   10.96.0.10       <none>        53/UDP,53/TCP,9153/TCP       12d

NAMESPACE     NAME                        DESIRED   CURRENT   READY   UP-TO-DATE   AVAILABLE   NODE SELECTOR            AGE
kube-system   daemonset.apps/kube-proxy   1         1         1       1            1           kubernetes.io/os=linux   12d

NAMESPACE       NAME                                       READY   UP-TO-DATE   AVAILABLE   AGE
default         deployment.apps/mongo-depl                 1/1     1            1           39h
default         deployment.apps/mongo-express              1/1     1            1           4h39m
default         deployment.apps/mongodb-deployment         1/1     1            1           38h
default         deployment.apps/nginx-depl                 1/1     1            1           39h
default         deployment.apps/nginx-deployment           1/1     1            1           38h
ingress-nginx   deployment.apps/ingress-nginx-controller   1/1     1            1           5m9s
kube-system     deployment.apps/coredns                    1/1     1            1           12d

NAMESPACE       NAME                                                  DESIRED   CURRENT   READY   AGE
default         replicaset.apps/mongo-depl-887485654                  1         1         1       39h
default         replicaset.apps/mongo-express-59444895cd              0         0         0       4h30m
default         replicaset.apps/mongo-express-7c54c57c6c              0         0         0       4h39m
default         replicaset.apps/mongo-express-854966995b              0         0         0       4h34m
default         replicaset.apps/mongo-express-f56d5b7ff               1         1         1       4h27m
default         replicaset.apps/mongodb-deployment-74788c5c54         1         1         1       37h
default         replicaset.apps/mongodb-deployment-7bc58f8b5f         0         0         0       38h
default         replicaset.apps/nginx-depl-85c9d7c5f4                 1         1         1       39h
default         replicaset.apps/nginx-deployment-77d8468669           1         1         1       38h
ingress-nginx   replicaset.apps/ingress-nginx-controller-768f948f8f   1         1         1       5m9s
kube-system     replicaset.apps/coredns-7db6d8ff4d                    1         1         1       12d

NAMESPACE       NAME                                       STATUS     COMPLETIONS   DURATION   AGE
ingress-nginx   job.batch/ingress-nginx-admission-create   Complete   1/1           26s        5m9s
ingress-nginx   job.batch/ingress-nginx-admission-patch    Complete   1/1           27s        5m9s
PS C:\Users\HP> kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.7.0/aio/deploy/recommended.yaml
namespace/kubernetes-dashboard created
serviceaccount/kubernetes-dashboard created
service/kubernetes-dashboard created
secret/kubernetes-dashboard-certs created
secret/kubernetes-dashboard-csrf created
secret/kubernetes-dashboard-key-holder created
configmap/kubernetes-dashboard-settings created
role.rbac.authorization.k8s.io/kubernetes-dashboard created
clusterrole.rbac.authorization.k8s.io/kubernetes-dashboard created
rolebinding.rbac.authorization.k8s.io/kubernetes-dashboard created
clusterrolebinding.rbac.authorization.k8s.io/kubernetes-dashboard created
deployment.apps/kubernetes-dashboard created
service/dashboard-metrics-scraper created
deployment.apps/dashboard-metrics-scraper created
PS C:\Users\HP> kubectl get deployments -n kubernetes-dashboard
NAME                        READY   UP-TO-DATE   AVAILABLE   AGE
dashboard-metrics-scraper   0/1     1            0           20s
kubernetes-dashboard        0/1     1            0           20s
PS C:\Users\HP> kubectl get pods -n kubernetes-dashboard
NAME                                         READY   STATUS              RESTARTS   AGE
dashboard-metrics-scraper-795895d745-vcjlr   0/1     ContainerCreating   0          46s
kubernetes-dashboard-56cf4b97c5-p8mkt        0/1     ContainerCreating   0          46s
PS C:\Users\HP> kubectl get pod -n kube-system
NAME                               READY   STATUS    RESTARTS      AGE
coredns-7db6d8ff4d-hd89q           1/1     Running   3 (43m ago)   12d
etcd-minikube                      1/1     Running   3 (43m ago)   12d
kube-apiserver-minikube            1/1     Running   3 (43m ago)   12d
kube-controller-manager-minikube   1/1     Running   3 (43m ago)   12d
kube-proxy-tj7jr                   1/1     Running   3 (43m ago)   12d
kube-scheduler-minikube            1/1     Running   3 (43m ago)   12d
storage-provisioner                1/1     Running   7 (42m ago)   12d
PS C:\Users\HP> kubectl get ns
NAME                   STATUS   AGE
default                Active   12d
ingress-nginx          Active   17m
kube-node-lease        Active   12d
kube-public            Active   12d
kube-system            Active   12d
kubernetes-dashboard   Active   11m
my-namespace           Active   41m
PS C:\Users\HP> kubectl get all -n kubernetes-dashboard
NAME                                             READY   STATUS    RESTARTS   AGE
pod/dashboard-metrics-scraper-795895d745-vcjlr   1/1     Running   0          12m
pod/kubernetes-dashboard-56cf4b97c5-p8mkt        1/1     Running   0          12m

NAME                                TYPE        CLUSTER-IP      EXTERNAL-IP   PORT(S)    AGE
service/dashboard-metrics-scraper   ClusterIP   10.101.35.42    <none>        8000/TCP   12m
service/kubernetes-dashboard        ClusterIP   10.97.182.226   <none>        443/TCP    12m

NAME                                        READY   UP-TO-DATE   AVAILABLE   AGE
deployment.apps/dashboard-metrics-scraper   1/1     1            1           12m
deployment.apps/kubernetes-dashboard        1/1     1            1           12m

NAME                                                   DESIRED   CURRENT   READY   AGE
replicaset.apps/dashboard-metrics-scraper-795895d745   1         1         1       12m
replicaset.apps/kubernetes-dashboard-56cf4b97c5        1         1         1       12m
PS C:\Users\HP> kubectl apply -f dashboard-ingress.yaml
error: the path "dashboard-ingress.yaml" does not exist
PS C:\Users\HP> cd C:\nginx
PS C:\nginx> kubectl apply -f dashboard-ingress.yaml
error: error parsing dashboard-ingress.yaml: error converting YAML to JSON: yaml: line 12: mapping values are not allowed in this context
PS C:\nginx> kubectl apply -f dashboard-ingress.yaml
error: error parsing dashboard-ingress.yaml: error converting YAML to JSON: yaml: line 12: mapping values are not allowed in this context
PS C:\nginx> kubectl apply -f dashboard-ingress.yaml
ingress.networking.k8s.io/dashboard-ingress created
PS C:\nginx> kubectl get ingress -n kubernetes-dashboard
NAME                CLASS   HOSTS           ADDRESS        PORTS   AGE
dashboard-ingress   nginx   dashboard.com   192.168.49.2   80      97s
PS C:\nginx> kubectl get ingress -n kubernetes-dashboard --watch
NAME                CLASS   HOSTS           ADDRESS        PORTS   AGE
dashboard-ingress   nginx   dashboard.com   192.168.49.2   80      14m

